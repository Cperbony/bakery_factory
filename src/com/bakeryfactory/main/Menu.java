/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.openswing.swing.internationalization.java.Language;
import org.openswing.swing.internationalization.java.XMLResourcesFactory;
import org.openswing.swing.mdi.client.ClientFacade;
import org.openswing.swing.mdi.client.Clock;
import org.openswing.swing.mdi.client.GenericStatusPanel;
import org.openswing.swing.mdi.client.MDIController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.mdi.java.ApplicationFunction;
import org.openswing.swing.permissions.client.LoginController;
import org.openswing.swing.permissions.client.LoginDialog;
import org.openswing.swing.tree.java.OpenSwingTreeNode;
import org.openswing.swing.util.client.ClientSettings;
import org.openswing.swing.util.java.Consts;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com  
 * 
 */
public class Menu implements MDIController, LoginController {

    private ClienteFachada clientFacade = null;
    private Connection conn = null;
    private Hashtable domains = new Hashtable();
    private String username = null;
    private Properties idiomas = new Properties();

    public Menu() {
        createConnection();
        clientFacade = new ClienteFachada(conn);

        Hashtable xmlFiles = new Hashtable();
        xmlFiles.put("EN", "Resources/Resources_en.xml");
        xmlFiles.put("IT", "Resources/Resources_it.xml");
        xmlFiles.put("PT_BR", "Resources/Resources_pt_br.xml");

        ClientSettings clientSettings = new ClientSettings(
                new XMLResourcesFactory(xmlFiles, false),
                domains);

        ClientSettings.BACKGROUND = "Wolf 076.jpg";
        ClientSettings.BACK_IMAGE_DISPOSITION = Consts.BACK_IMAGE_CENTERED;
        ClientSettings.TREE_BACK = "Wolf 107.jpg";
        ClientSettings.VIEW_BACKGROUND_SEL_COLOR = true;
        ClientSettings.VIEW_MANDATORY_SYMBOL = true;
        ClientSettings.ALLOW_OR_OPERATOR = false;
        ClientSettings.INCLUDE_IN_OPERATOR = false;
        ClientSettings.SHOW_SCROLLBARS_IN_MDI = false;
        ClientSettings.FILTER_PANEL_ON_GRID = true;

        ClientSettings.getInstance().setLanguage("PT_BR");

        idiomas.setProperty("EN", "English");
        idiomas.setProperty("IT", "Italiano");
        idiomas.setProperty("PT_BR", "Português do Brasil");

        LoginDialog d = new LoginDialog(
                null,
                false,
                this,
                "Autenticação",
                "Login",
                'L',
                "Sair",
                'S',
                "Armazenar Informações",
                "bakery_factory",
                null,
                idiomas,
                "PT_BR");

    }

    /**
     * Method called after MDI creation.
     * @param frame
     */
   @Override
    public void afterMDIcreation(MDIFrame frame) {
        GenericStatusPanel userPanel = new GenericStatusPanel();
        userPanel.setColumns(12);
        MDIFrame.addStatusComponent(userPanel);
        userPanel.setText(username);
        MDIFrame.addStatusComponent(new Clock());
    }

    /**
     * @return 
     * @see JFrame getExtendedState method
     */
   @Override
    public int getExtendedState() {
        return JFrame.MAXIMIZED_BOTH;
    }

    /**
     * @return client facade, invoked by the MDI Frame tree/menu
     */
   @Override
    public ClientFacade getClientFacade() {
        return clientFacade;
    }

    /**
     * Method used to destroy application.
     */
   @Override
    public void stopApplication() {
        System.exit(0);
    }

    /**
     * Defines if application functions must be viewed inside a tree panel of MDI Frame.
     * @return <code>true</code> if application functions must be viewed inside a tree panel of MDI Frame, <code>false</code> no tree is viewed
     */
   @Override
    public boolean viewFunctionsInTreePanel() {
        return true;
    }

    /**
     * Defines if application functions must be viewed in the menubar of MDI Frame.
     * @return <code>true</code> if application functions must be viewed in the menubar of MDI Frame, <code>false</code> otherwise
     */
    @Override
    public boolean viewFunctionsInMenuBar() {
        return true;
    }

    /**
     * @return <code>true</code> if the MDI frame must show a login menu in the menubar, <code>false</code> no login menu item will be added
     */
   @Override
    public boolean viewLoginInMenuBar() {
        return true;
    }

    /**
     * @return application title
     */
   @Override
    public String getMDIFrameTitle() {
        return "Bakery Factory - Controle de Produção para panificadoras";
    }

    /**
     * @return text to view in the about dialog window
     */
    @Override
    public String getAboutText() {
        return "Bakery Factory - Controle de Produção para panificadoras\n" +
                "\n" +
                "Copyright: Copyright (C) 2015\n" +
                "Autor: Claudinei Aparecido Perboni";
    }

    /**
     * @return image name to view in the about dialog window
     */
    @Override
    public String getAboutImage() {
        return "about.jpg";
    }

    /**
     * @param parentFrame parent frame
     * @return a dialog window to logon the application; the method can return null if viewLoginInMenuBar returns false
     */
   @Override
    public JDialog viewLoginDialog(JFrame parentFrame) {
        JDialog d = new LoginDialog(
                parentFrame,
                true,
                this,
                "Autenticação",
                "Login",
                'L',
                "Sair",
                'S',
                "Armazenar Informação",
                "bakery_factory",
                null,
                idiomas,
                ClientSettings.getInstance().getResources().getLanguageId());
        return d;
    }

    /**
     * @return maximum number of failed login
     */
    @Override
    public int getMaxAttempts() {
        return 3;
    }

    /**
     * Method called by MDI Frame to authenticate the user.
     * @param loginInfo login information, like username, password, ...
     * @return <code>true</code> if user is correcly authenticated, <code>false</code> otherwise
     * @throws java.lang.Exception
     */
    @Override
    public boolean authenticateUser(Map loginInfo) throws Exception {
        if ("ADMIN".equalsIgnoreCase((String) loginInfo.get("username")) &&
                "ADMIN".equalsIgnoreCase((String) loginInfo.get("password"))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
       new Menu();
    }

    /**
     * Method called by LoginDialog to notify the sucessful login.
     * @param loginInfo login information, like username, password, ...
     */
    @Override
    public void loginSuccessful(Map loginInfo) {
        username = loginInfo.get("username").toString().toUpperCase();
        if (username.equals("ADMIN")) {
            ClientSettings.getInstance().setLanguage("EN");
        } else if (username.equals("ADMIN")) {
            ClientSettings.getInstance().setLanguage("IT");
        } else if (username.equals("ADMIN")) {
            ClientSettings.getInstance().setLanguage("PT_BR");
        }

        MDIFrame mdi = new MDIFrame(this);

        //configura os botões da barra de ferramentas
        mdi.addButtonToToolBar("condominio.png", "Cadastro de Condomínios");
        mdi.addButtonToToolBar("fornecedor.png", "Cadastro de Fornecedores");
        mdi.addButtonToToolBar("banco.png", "Cadastro de Bancos");
        mdi.addButtonToToolBar("inquilino.png", "Cadastro de Inquilinos");
        mdi.addSeparatorToToolBar();
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("plano_conta.png", "Cadastro do Centro de Custo (Contas)");
        mdi.addButtonToToolBar("contrato.png", "Cadastro dos Contratos com Fornecedores");
        mdi.addSeparatorToToolBar();
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("boleto.png", "Emissão de Boletos");
        mdi.addButtonToToolBar("gas.png", "Controle do Gás");
        mdi.addSeparatorToToolBar();
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("pagar.png", "Contas a Pagar");
        mdi.addButtonToToolBar("receber.png", "Confirma Recebimentos");
        mdi.addButtonToToolBar("cheque.png", "Conciliação de Cheques");
        mdi.addButtonToToolBar("bancario.png", "Movimento Bancário");
        mdi.addSeparatorToToolBar();
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("ata.png", "Controle de Atas");
        mdi.addButtonToToolBar("carta.png", "Cartas de Cobrança");
        mdi.addSeparatorToToolBar();
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("sair.png", "Sair da Aplicação");
    }

    /**
     * @return <code>true</code> if the MDI frame must show a change language menu in the menubar, <code>false</code> no change language menu item will be added
     */
    @Override
    public boolean viewChangeLanguageInMenuBar() {
        return true;
    }

    /**
     * @return list of languages supported by the application
     */
    @Override
    public ArrayList getLanguages() {
        ArrayList list = new ArrayList();
        list.add(new Language("EN", "English"));
        list.add(new Language("IT", "Italiano"));
        list.add(new Language("PT_BR", "Portugês do Brasil"));
        return list;
    }

    /**
     * @return application functions (ApplicationFunction objects), organized as a tree
     */
    @Override
    public DefaultTreeModel getApplicationFunctions() {
        DefaultMutableTreeNode root = new OpenSwingTreeNode();

        DefaultTreeModel model = new DefaultTreeModel(root);

        ApplicationFunction n1 = new ApplicationFunction("Cadastro", null);
        ApplicationFunction n2 = new ApplicationFunction("Movimento", null);

        ApplicationFunction n11 = new ApplicationFunction("Condomínios", "condominio", null, "getCondominio");
        ApplicationFunction n12 = new ApplicationFunction("Inquilinos", "inquilino", null, "getInquilino");
        ApplicationFunction n13 = new ApplicationFunction("Bancos", "banco", null, "getBanco");
        ApplicationFunction n14 = new ApplicationFunction("Fornecedores", "fornecedor", null, "getFornecedor");
        ApplicationFunction n15 = new ApplicationFunction(true);
        ApplicationFunction n16 = new ApplicationFunction("Centro de Custo", "centro_custo", null, "getCentroCusto");
        ApplicationFunction n17 = new ApplicationFunction("Contratos", "contrato", null, "getContrato");

        ApplicationFunction n21 = new ApplicationFunction("Contas a Receber", null);
        ApplicationFunction n211 = new ApplicationFunction("Emissao de Boletos", "boleto", null, "getBoleto");
        ApplicationFunction n212 = new ApplicationFunction("Confirma Recebimentos", "receber", null, "getReceber");
        ApplicationFunction n22 = new ApplicationFunction("Contas a Pagar", "pagar", null, "getPagar");
        ApplicationFunction n23 = new ApplicationFunction("Controle do Gás", "gas", null, "getGas");
        ApplicationFunction n24 = new ApplicationFunction("Conciliação de Cheques", "cheque", null, "getCheque");
        ApplicationFunction n25 = new ApplicationFunction("Movimento Bancário", "bancario", null, "getBancario");
        ApplicationFunction n26 = new ApplicationFunction(true);
        ApplicationFunction n27 = new ApplicationFunction("Controle de Atas", "ata", null, "getAta");
        ApplicationFunction n28 = new ApplicationFunction("Cartas de Cobrança", "cobranca", null, "getCobranca");

        n1.add(n11);
        n1.add(n12);
        n1.add(n13);
        n1.add(n14);
        n1.add(n15);
        n1.add(n16);
        n1.add(n17);

        n2.add(n21);
        n21.add(n211);
        n21.add(n212);
        n2.add(n22);
        n2.add(n23);
        n2.add(n24);
        n2.add(n25);
        n2.add(n26);
        n2.add(n27);
        n2.add(n28);

        root.add(n1);
        root.add(n2);

        return model;
    }

    /**
     * Create the database connection
     */
    private void createConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bakery_factory?user=root&password=root");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return <code>true</code> if the MDI frame must show a panel in the bottom, containing last opened window icons, <code>false</code> no panel is showed
     */
    @Override
    public boolean viewOpenedWindowIcons() {
        return true;
    }

    @Override
    public boolean viewFileMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
