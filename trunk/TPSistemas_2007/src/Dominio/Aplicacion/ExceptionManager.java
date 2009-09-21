/*
 * ExceptionManager.java
 *
 * Created on 8 de abril de 2007, 13:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Dominio.Aplicacion;

/**
 *
 * @author Mariano
 */
public class ExceptionManager {
    
    
    public static void ManageException (Exception e) { 
        System.out.println ("Se ha producido una excepción"); 
        System.out.println (e.getMessage());
        e.printStackTrace(System.out); 
    }
}
