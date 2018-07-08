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
public class NumberFormatService {

    public static String format(double valor){
        String valorTexto = String.valueOf(valor);
        valorTexto = valorTexto.replace("." , "");
        valorTexto = valorTexto.replace("," , ".");
        
        return valorTexto;
    }
}
