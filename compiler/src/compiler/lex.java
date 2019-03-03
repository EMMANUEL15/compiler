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
    private String t_reservadas[]={"main","cad","int","print"};
    String Simbolos[]={"(",")",":"};
    
     public void cargar(String a)throws FileNotFoundException,IOException,Exception{
            File   archivo= new File(a);
            FileReader leido= new FileReader(archivo);
            BufferedReader  m = new BufferedReader(leido);
            
           String linea=m.readLine();
        while(linea!=null){
            char row[] =linea.toCharArray();
            letter(row);
            linea = m.readLine();
            } 
            }
     private void letter(char [] row){
         String palabra = "";
        for(int i=0;i<row.length;i++){
            if(Character.isDigit(row[i])){                      //numeros
                palabra = palabra + row[i];
            }else if(Character.isAlphabetic(row[i])){           //alfabeto  
                palabra = palabra + row[i];
            }
            else{
                if(row[i] == '.'){                      // PUNTO
                    verificar(palabra);
                    System.out.println("punto .");
                    palabra = "";
                }else if(!palabra.equals("")){          //ANALIZAR PALABRA
                    verificar(palabra);
                    palabra = "";
                    i--;
                }else{                                  // ANALIZAR SIMBOLO
                    simboloR(String.valueOf(row[i]));
                }
            }
        }
        if(!palabra.equals("")){}                        // VERIFICAR LA ULTIMA PALABRA
            verificar(palabra);
            System.out.println("");
     }
     private void verificar(String palabra){                     //   INDETIFICADOR DE PALABRAS RESERVDAS
         boolean band = false;
         for(int i=0; i<t_reservadas.length; i++){
             if(t_reservadas[i].equals(palabra)){
                 System.out.println(" palabra reservada "+palabra);
                 i = t_reservadas.length;
                 band = true;
             }
         }
         if(band==false){
                 System.out.println("palabra no reservada "+palabra);
             }
     }
     private void simboloR(String simbolo){                         // IDENTIFOCADOR DE SIMBOLOR Y OPERANDOS
         switch(simbolo){
             case "+":
                 System.out.println("operando +");
             break;
             case "-":
                 System.out.println("operando -");
             break;
             case "*":
                 System.out.println("operando *");
             break;
             case "/":
                 System.out.println("operando /");
             break;
             case "=":
                 System.out.println("operando =");
             break;
             case "'":
                 System.out.println("comilla '");
             break;
             case "{":
                 System.out.println("llave {");
             break;
             case "}":
                 System.out.println("llave }");
             break;
             case "#":
                 System.out.println("comentario #");
             break;
             case " ":
             break;
             default:
                boolean band = false;
                for(int i=0; i<t_reservadas.length; i++){
                    if(Simbolos[i].equals(simbolo)){
                         System.out.println(" simbolo aceptado "+simbolo);
                        i = t_reservadas.length;
                        band = true;
                    }
                }
                if(band == false){
                    System.out.println("simbolo no aceptado "+simbolo);
                }
             break;
         }
     }
}