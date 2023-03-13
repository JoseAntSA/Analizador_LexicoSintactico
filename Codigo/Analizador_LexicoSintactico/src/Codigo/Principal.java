
/*
- SÁNCHEZ ALANIS JOSÉ ANTONIO
*/

package Codigo;
import java.io.*;
import java.nio.file.*;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta = "C:/Users/anton/Documents/Semestre6/Compiladores/Analizador/Analizador_Lexico/src/Codigo/Lexer.flex";
        String ruta2 = "C:/Users/anton/Documents/Semestre6/Compiladores/Analizador/Analizador_Lexico/src/Codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/anton/Documents/Semestre6/Compiladores/Analizador/Analizador_Lexico/src/Codigo/Sintax.cup"}; 
        //generarLexer(ruta, ruta2, rutaS);
        Interfaz vtn = new Interfaz();
    }
    public static void generarLexer(String ruta, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        //archivo = new File(ruta);
        //JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/anton/Documents/Semestre6/Compiladores/Analizador/Analizador_Lexico/src/Codigo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Users/anton/Documents/Semestre6/Compiladores/Analizador/Analizador_Lexico/sym.java"), 
                Paths.get("C:/Users/anton/Documents/Semestre6/Compiladores/Analizador/Analizador_Lexico/src/Codigo/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/anton/Documents/Semestre6/Compiladores/Analizador/Analizador_Lexico/src/Codigo/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/anton/Documents/Semestre6/Compiladores/Analizador/Analizador_Lexico/Sintax.java"), 
                Paths.get("C:/Users/anton/Documents/Semestre6/Compiladores/Analizador/Analizador_Lexico/src/Codigo/Sintax.java")
        );
    }
}