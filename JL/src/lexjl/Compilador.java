package lexjl;

import identifiersTable.IdentifiersTable;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import codeGeneration.P;
import jlAST.Program;
import sinjl.AnalizadorSintactico;

public class Compilador {
	
	/**
	 * Clase principal que alberga el Main y dirige las etapas de la compilacion.
	 * @param args Recibimos dos argumentos, el primero es un archivo con nuestro
	 * codigo y el segundo el archivo de salida compilado.
	 */
	public static void main(String[] args) {
		Program result = null;
		
		// Analisis lexico y sintactico
		try {
			String file = args[0];
			AnalizadorSintactico asin = new AnalizadorSintactico(
					new AnalizadorLexico(new FileReader(file)));
			result = (Program) asin.parse().value;
			System.out.println("Analisis lexico OK.");
			System.out.println("Analisis Sintactico OK.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Identificacion de identificadores
		IdentifiersTable t = new IdentifiersTable();
		if (result.identifyNode(t)) {
			System.out.println("Fase de identificacion de identificadores OK.");
		} else {
			System.err
					.println("Error en fase de identificacion de identificadores.");
			return;
		}
		
		// Comprobacion de tipos
		if (result.verifyTypes()) {
			System.out.println("Fase de chequeo de tipos OK.");
		} else {
			System.err.println("Error en fase de chequeo de tipos.");
			return;
		}
		
		// Generacion de codigo y numeracion de instrucciones
		ArrayList<P> list = result.generateCode(t.getMaxSizeStack());

		int contador = 0;
		for (P i : list) {
			i.setNumInstruction(contador++);
		}

		// Escribimos codigo en el archivo de salida.
		try {
			FileWriter writer = new FileWriter(new File(args[1]));
			for (P i : list) {
				writer.write(i.code());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
