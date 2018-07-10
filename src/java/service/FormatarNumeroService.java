/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author fernanda
 */
public class FormatarNumeroService {
 
    public static String formatarDouble(double valor){
        String valorString = String.valueOf(valor);
        valorString =  valorString.replaceAll(".", "");
        valorString =  valorString.replaceAll(",", ".");
        
        return valorString;
    }
}
