/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.util;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
import java.text.ParseException;
import javafx.scene.text.Text;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com
 *
 */
public class ValidaCEP {
    
    public static boolean isCep(String cep) throws ParseException {
        MaskFormatter maskCEP = new MaskFormatter("##.###-###");
        maskCEP.setValidCharacters("0123456789");
        //cep.setFormatter(maskCEP);
        
        if (cep.length() == 8) {
            cep = cep.substring(0, 5) + "-"
                    + cep.substring(5, 3);
    return true;
        }else{
    return false;
}
    }

}


