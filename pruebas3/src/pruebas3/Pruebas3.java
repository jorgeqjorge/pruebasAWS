/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas3;

import java.awt.AWTException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class Pruebas3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Segunda s = new Segunda();
        try {
//            s.ping();
            s.ruebaSitio();
        } catch (InterruptedException ex) {
            Logger.getLogger(Pruebas3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(Pruebas3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
