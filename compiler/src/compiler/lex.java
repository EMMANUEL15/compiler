package compiler;
import  java.io.BufferedReader ;
import java.io.File;
import java.io.FileNotFoundException;
import  java.io.FileReader ;
import java.io.IOException;

/**
 * @author Emanuel Lpz
 */
public class lex {
     public void cargar(String a)throws FileNotFoundException,IOException,Exception{
            File   archivo= new File(a);
            FileReader leido= new FileReader(archivo);
            BufferedReader  m = new BufferedReader(leido);
            
           String linea=m.readLine();
        while(linea!=null){
            System.out.println(" "+linea);
            linea = m.readLine();
            } 
            }
   
}
