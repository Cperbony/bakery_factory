/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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

        ClientSettings.BACKGROUND = "panificadora.jpg";
        ClientSettings.BACK_IMAGE_DISPOSITION = Consts.BACK_IMAGE_CENTERED;
        ClientSettings.TREE_BACK = "Tela_Tree_Back.jpg";
        ClientSettings.VIEW_BACKGROUND_SEL_COLOR = true;
        ClientSettings.VIEW_MANDATORY_SYMBOL = true;
        ClientSettings.ALLOW_OR_OPERATOR = false;
        ClientSettings.INCLUDE_IN_OPERATOR = false;
        ClientSettings.SHOW_SCROLLBARS_IN_MDI = false;
        ClientSettings.FILTER_PANEL_ON_GRID = true;
        ClientSettings.SHOW_PAGINATION_BUTTONS_ON_GRID = true;
        ClientSettings.SHOW_POPUP_MENU_CLOSE = true;

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
        // d.setSize(600, 400);

    }

    /**
     * Method called after MDI creation.
     *
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
     * @return @see JFrame getExtendedState method
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
     * Defines if application functions must be viewed inside a tree panel of
     * MDI Frame.
     *
     * @return <code>true</code> if application functions must be viewed inside
     * a tree panel of MDI Frame, <code>false</code> no tree is viewed
     */
    @Override
    public boolean viewFunctionsInTreePanel() {
        return true;
    }

    /**
     * Defines if application functions must be viewed in the menubar of MDI
     * Frame.
     *
     * @return <code>true</code> if application functions must be viewed in the
     * menubar of MDI Frame, <code>false</code> otherwise
     */
    @Override
    public boolean viewFunctionsInMenuBar() {
        return true;
    }

    /**
     * @return <code>true</code> if the MDI frame must show a login menu in the
     * menubar, <code>false</code> no login menu item will be added
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
        return "Bakery Factory - Controle de Produção para Panificadoras";
    }

    /**
     * @return text to view in the about dialog window
     */
    @Override
    public String getAboutText() {
        return "Bakery Factory - Controle de Produção para Panificadoras\n"
                + "\n"
                + "Copyright: Copyright (C) 2015\n"
                + "Autor: Claudinei Aparecido Perboni";
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
     * @return a dialog window to logon the application; the method can return
     * null if viewLoginInMenuBar returns false
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
     *
     * @param loginInfo login information, like username, password, ...
     * @return <code>true</code> if user is correcly authenticated,
     * <code>false</code> otherwise
     * @throws java.lang.Exception
     */
    @Override
    public boolean authenticateUser(Map loginInfo) throws Exception {
        return "ADMIN".equalsIgnoreCase((String) loginInfo.get("username"))
                && "ADMIN".equalsIgnoreCase((String) loginInfo.get("password"))
                || "PABLO".equalsIgnoreCase((String) loginInfo.get("username"))
                && "PABLO".equalsIgnoreCase((String) loginInfo.get("password"))
                || "CLAUS".equalsIgnoreCase((String) loginInfo.get("username"))
                && "CLAUS".equalsIgnoreCase((String) loginInfo.get("password"));
    }

    public static void main(String[] args) {
        new Menu();
    }

    /**
     * Method called by LoginDialog to notify the sucessful login.
     *
     * @param loginInfo login information, like username, password, ...
     */
    @Override
    public void loginSuccessful(Map loginInfo) {
        username = loginInfo.get("username").toString().toUpperCase();
        switch (username) {
            case "ADMIN":
                ClientSettings.getInstance().setLanguage("EN");
                break;
            case "PABLO":
                ClientSettings.getInstance().setLanguage("IT");
                break;
            case "CLAUS":
                ClientSettings.getInstance().setLanguage("PT_BR");
                break;
        }

        MDIFrame mdi = new MDIFrame(this);

        //configura os botões da barra de ferramentas
        mdi.addButtonToToolBar("account_user.png", "Cadastro de Usuários");
        mdi.addButtonToToolBar("empresa.png", "Cadastro de Empresas");
        mdi.addButtonToToolBar("enderecos.png", "Cadastro de Endreços");
        mdi.addButtonToToolBar("telefone.png", "Cadastro de Telefone");
        mdi.addButtonToToolBar("setores.png", "Cadastro de Setores");
        mdi.addButtonToToolBar("ingredientes.png", "Cadastro de Ingredientes");
        mdi.addButtonToToolBar("receitas.png", "Cadastro de Receitas");
        mdi.addSeparatorToToolBar();
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("modo_preparo_note.png", "Cadastro de Modo de Preparo");
        mdi.addButtonToToolBar("classe_prod.png", "Cadastro de Classe de Produtos");
        mdi.addButtonToToolBar("congelados.png", "Cadastro de Congelados");
        mdi.addButtonToToolBar("produtos.png", "Cadastro de Produtos");
        mdi.addButtonToToolBar("nota_compras.png", "Cadastro de Notas de Compras");
        mdi.addSeparatorToToolBar();
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("requisicao.png", "Cadastro do Requisição de Produção");
        mdi.addButtonToToolBar("calendario_prod.png", "Cadastro de Calendário de Producão");
        mdi.addButtonToToolBar("calculo_receitas.png", "Cadastro de Cálculo de Receitas");
        mdi.addSeparatorToToolBar();
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("kit_producao.png", "Produção Final");
        mdi.addButtonToToolBar("calendar3.png", "Consultas");
        mdi.addButtonToToolBar("distribuicao.png", "Distribuição");
        mdi.addSeparatorToToolBar();
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("relatorios.png", "Relatorio de Produção");
        mdi.addButtonToToolBar("printer.png", "Impressão de Relatórios");
        mdi.addSeparatorToToolBar();
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("sair.png", "Sair da Aplicação");

    }

    /**
     * @return <code>true</code> if the MDI frame must show a change language
     * menu in the menubar, <code>false</code> no change language menu item will
     * be added
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
     * @return application functions (ApplicationFunction objects), organized as
     * a tree
     */
    @Override
    public DefaultTreeModel getApplicationFunctions() {
        DefaultMutableTreeNode root = new OpenSwingTreeNode();

        DefaultTreeModel model = new DefaultTreeModel(root);

        ApplicationFunction n1 = new ApplicationFunction("Cadastros", null);
        ApplicationFunction n2 = new ApplicationFunction("Produção", null);
        ApplicationFunction n3 = new ApplicationFunction("Movimentos", null);

        ApplicationFunction n1a = new ApplicationFunction("Usuarios", "usuarios", null, "getUsuarios");
        ApplicationFunction n111 = new ApplicationFunction("Empresas", "empresa", null, "getEmpresas");
        ApplicationFunction n112 = new ApplicationFunction("Enderecos", "endereco", null, "getEnderecos");
        ApplicationFunction n113 = new ApplicationFunction("Telefones", "telefone", null, "getTelefone");
        ApplicationFunction n1b = new ApplicationFunction("Setores", "setores", null, "getSetores");
        ApplicationFunction n1c = new ApplicationFunction("Ingredientes", "ingredientes", null, "getIngredientes");
        ApplicationFunction n1d = new ApplicationFunction("Receitas de Produção", "receitas", null, "getReceitas");
        ApplicationFunction n1e = new ApplicationFunction(true);
        ApplicationFunction n1f = new ApplicationFunction("Modo de Preparo", "modo_preparo", null, "getModoPreparo");
        ApplicationFunction n1g = new ApplicationFunction("Classe de Produtos", "classe_produtos", null, "getClasseProdutos");
        ApplicationFunction n1h = new ApplicationFunction("Congelados", "congelados", null, "getCongelados");
        ApplicationFunction n1i = new ApplicationFunction("Produtos", "produtos", null, "getProdutos");
        ApplicationFunction n1j = new ApplicationFunction(true);
        ApplicationFunction n1k = new ApplicationFunction("Notas de Compras", "notasCompras", null, "getNotaCompras");

        ApplicationFunction n21 = new ApplicationFunction("Requisição de Produção", "requisicao", null, "getRequisicao");
        ApplicationFunction n211 = new ApplicationFunction("Calendario de Producao", "calendarioProducao", null, "getCalendarioProducao");
        ApplicationFunction n212 = new ApplicationFunction("Calculo de Receitas", "calculoReceitas", null, "getCalculoReceitas");
        ApplicationFunction n22 = new ApplicationFunction(true);
        ApplicationFunction n23 = new ApplicationFunction("Kit de Produção", "kitProducao", null, "getKitProducao");
        ApplicationFunction n24 = new ApplicationFunction("Produção Final", "producaoFinal", null, "getProducaoFinal");
        ApplicationFunction n25 = new ApplicationFunction("Consultas", "consultarProducao", null, "getconsultaProducao");
        ApplicationFunction n26 = new ApplicationFunction("Distribuição", "distribuicaoProducao", null, "getdistribuicaoProducao");
        ApplicationFunction n27 = new ApplicationFunction(true);

        ApplicationFunction n31 = new ApplicationFunction("Relatorio de Produção", "relatorioProducao", null, "getRelatorioProducao");
        ApplicationFunction n32 = new ApplicationFunction("Impressão de Relatorios", "impressao", null, "getImpressao");

        n1.add(n1a);
        n1.add(n111);
        n1.add(n112);
        n1.add(n113);
        n1.add(n1b);
        n1.add(n1c);
        n1.add(n1d);
        n1.add(n1e);
        n1.add(n1f);
        n1.add(n1g);
        n1.add(n1h);
        n1.add(n1i);
        n1.add(n1j);
        n1.add(n1k);

        n2.add(n21);
        n2.add(n211);
        n2.add(n212);
        n2.add(n22);
        n2.add(n23);
        n2.add(n24);
        n2.add(n25);
        n2.add(n26);
        n2.add(n27);

        n3.add(n31);
        n3.add(n32);

        root.add(n1);
        root.add(n2);
        root.add(n3);

        return model;
    }

    /**
     * Create the database connection
     */
    private void createConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery_factory?user=root&password=root");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return <code>true</code> if the MDI frame must show a panel in the
     * bottom, containing last opened window icons, <code>false</code> no panel
     * is showed
     */
    @Override
    public boolean viewOpenedWindowIcons() {
        return true;
    }

    @Override
    public boolean viewFileMenu() {
        return true;

    }
}
