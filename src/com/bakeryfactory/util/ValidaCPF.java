/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.util;

import java.util.InputMismatchException;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com
 *
 */
public class ValidaCPF {

    public static boolean isCPF(String CPF) {
// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char digito10, digito11;
        int somaDigitos, i, resultado, peso;
        int num = 0;

        try {
// Calculo do 1o. Digito Verificador
            somaDigitos = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
// converte o i-esimo caractere do CPF em um numero
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                somaDigitos = (somaDigitos + (num * peso));
                peso = peso - 1;
            }
            resultado = 11 - (somaDigitos % 11);
            if ((resultado == 10) || (resultado == 11)) {
                digito10 = '0';
            } else {
                digito10 = (char) (resultado + 48);
            }

// converte no respectivo caractere numerico 
            // Calculo do 2o. Digito Verificador
            somaDigitos = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                somaDigitos = (somaDigitos + (num * peso));
                peso = peso - 1;
            }

            resultado = 11 - (somaDigitos % 11);
            if ((resultado == 10) || (resultado == 11)) {
                digito11 = '0';
            } else {
                digito11 = (char) (resultado + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((digito10 == CPF.charAt(9)) && (digito11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static String imprimeCPF(String CPF) {
        return (CPF.substring(0, 3) + "."
                + CPF.substring(3, 6) + "."
                + CPF.substring(6, 9) + "-"
                + CPF.substring(9, 11));
    }
}
