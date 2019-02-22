package compiler;
/**
 * @author Emanuel lopez
 */
public class Compiler {
     public static void main(String[] args) throws Exception {
      lex l = new lex();
      l.cargar("lenguaje.txt");
    }
    
}
