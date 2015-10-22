/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.util;

import java.util.InputMismatchException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com
 *
 */
public class ValidaCNPJ {

    public static boolean isCNPJ(String CNPJ) {
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
         || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333")
         || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
         || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777")
         || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999")
         || (CNPJ.length() != 14)) {
            return (false);
        }

        char digito13, digito14;
        int sm, i, r, num, peso;

        //Cálculo do 1o dígito Verificador
        sm = 0;
        peso = 2;

        for (i = 11; i >= 0; i--) {
// converte o i-ésimo caractere do CNPJ em um número:
// por exemplo, transforma o caractere '0' no inteiro 0 
// (48 eh a posição de '0' na tabela ASCII)

            num = (int) (CNPJ.charAt(i) - 48);
            sm = (sm + (num * peso));
            peso = peso + 1;
            if (peso == 10) {
                peso = 2;
            }
        }

        r = sm % 11;
        if ((r == 0) || (r == 1)) {
            digito13 = '0';
        } else {
            digito13 = (char) ((11 - r) + 48);
        }

        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 2;

        for (i = 12; i >= 0; i--) {
            num = (int) (CNPJ.charAt(i) - 48);
            sm = (sm + (num * peso));
            peso = peso + 1;
            if (peso == 10) {
                peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                digito14 = '0';
            } else {
                digito14 = (char) ((11 - r) + 48);
            }

// Verifica se os dígitos calculados conferem com os dígitos informados.
            try {
                if ((digito13 == CNPJ.charAt(12)) && (digito14 == CNPJ.charAt(13))) {
                    return (true);
                } else {
                    return (false);
                }
            } catch (InputMismatchException erro) {
                erro.printStackTrace();
            }
            return (false);
        }
        return false;
    }

    public static String imprimeCNPJ(String CNPJ) {
        // máscara do CNPJ: 99.999.999.9999-99

        return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
                CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
                CNPJ.substring(12, 14));
    }
    
    // MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");

}
