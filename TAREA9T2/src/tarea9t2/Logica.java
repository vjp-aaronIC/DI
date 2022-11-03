/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea9t2;

import java.io.*;

/**
 *
 * @author aiglesiasc19
 */
public class Logica {
    
    //comprobar log
    public static boolean comprobarUsuario(String user, String pass){
        boolean correcto = false;
        
        File fichero = new File("users.txt");
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            
            String linea;
            String [] lineaSplit;
            
            linea = br.readLine();
            while(linea != null && !correcto){
                lineaSplit = linea.split(":");
                if(user.equals(lineaSplit[0]) && pass.equals(lineaSplit[1])){
                    correcto = true;
                }
                
                linea = br.readLine();
            }
            
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        return correcto;
    }
    
    //añadir usuario
    public static void escribirUsuario(String user, String pass){
        File fichero = new File("users.txt");
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try {
            fw = new FileWriter(fichero, true);
            pw = new PrintWriter(fw);
            
            pw.println(user+":"+pass);
            
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
