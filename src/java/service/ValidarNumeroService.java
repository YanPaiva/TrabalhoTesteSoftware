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
public class ValidarNumeroService {
 
    public static boolean inteiro(String s) {
        char[] c = s.toCharArray();
        boolean d = true;
        for ( int i = 0; i < c.length; i++ ){
            if (!Character.isDigit( c[ i ] ) ) {
                d = false;
                break;
            }
        }
        return d;
    }

}
