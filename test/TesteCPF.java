
import com.bakeryfactory.util.ValidaCPF;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com
 *
 */
public class TesteCPF {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        String CPF;
        System.out.printf("Informe um CPF: ");
        CPF = ler.next();
        System.out.printf("\nResultado: ");

// usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
        if (ValidaCPF.isCPF(CPF) == true) {
            System.out.printf("%s\n", ValidaCPF.imprimeCPF(CPF));
        } else {
            System.out.printf("Erro, CPF invalido !!!\n");
        }
    }
}
