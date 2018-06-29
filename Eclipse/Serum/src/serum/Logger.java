package serum;

import java.io.File;
import java.io.IOException;

/**
 * @author David Rubio
 */
public abstract class Logger {

    public static java.io.PrintStream log;

    static {
        java.io.File file = new File("log.txt");
        try {
            file.createNewFile();
            log = new java.io.PrintStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static java.io.PrintStream codeExit;

    static {
        java.io.File file = new File("code.p");
        try {
            file.createNewFile();
            java.util.Scanner sc = new java.util.Scanner(AnalizadorSintactico.file);
            codeExit = new java.io.PrintStream(file);
            codeExit.println("{");
            while (sc.hasNextLine())
                codeExit.println(sc.nextLine());
            codeExit.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void report_error(String message){
        log.println(message);
        System.err.println(message);
    }
}
