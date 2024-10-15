/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;
import Controller.Gerenciamento;
import Controller.Menu;
import java.io.IOException;
/**
 *
 * @author Muzime
 */
public class JDBC {
    Gerenciamento gerenciamento;
    Menu menu;
    /**
     * @param args the command line arguments
     */
    public JDBC() throws IOException{
        menu = new Menu();
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new JDBC();
    }
    
}
