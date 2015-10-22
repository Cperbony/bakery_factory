/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.util;

import java.text.ParseException;
import java.util.InputMismatchException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com
 *
 */
public class MascarasUtil {

    public MascarasUtil() throws ParseException {
    }

    public void mascaraCEP(String cep) throws ParseException {
        MaskFormatter maskCEP = new MaskFormatter("##.###-###");
        maskCEP.setValidCharacters("0123456789");
        //setar.setFormatter(maskCep); 
    }

    public void mascaraMesAno(String mesAno) throws ParseException {
        MaskFormatter mascaraMesAno = new MaskFormatter("##/####");
        mascaraMesAno.setValidCharacters("0123456789");
        //setar.setFormatter(mascaraMesAno); 
    }

    public void mascaraCNPJ(String CNPJ) throws ParseException {
        MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
        mascaraCNPJ.setValidCharacters("0123456789");
        //setar.setFormatter(mascaraCNPJ); 
    }

    public void mascaraCPF(String CPF) throws ParseException {
        MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
        mascaraCPF.setValidCharacters("0123456789");
        //setar.setFormatter(mascaraCPF); 
    }
    
       public void mascaraRG(String RG) throws ParseException {
        MaskFormatter mascaraRG = new MaskFormatter("##.###.###-##");
        mascaraRG.setValidCharacters("0123456789");
        //setar.setFormatter(mascaraRG); 
    }
    
    

}
