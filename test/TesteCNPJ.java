
import com.bakeryfactory.util.ValidaCNPJ;
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
public class TesteCNPJ {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String CNPJ;

        System.out.printf("Informe um CNPJ: ");
        CNPJ = ler.next();
        System.out.printf("\nResultado: ");

// usando os métodos isCNPJ() e imprimeCNPJ() da classe "ValidaCNPJ" 
        if (ValidaCNPJ.isCNPJ(CNPJ) == true) {
            System.out.printf("%s\n", ValidaCNPJ.imprimeCNPJ(CNPJ));
        } else {
            System.out.printf("Erro, CNPJ inválido !!!\n");
        }
    }

}
