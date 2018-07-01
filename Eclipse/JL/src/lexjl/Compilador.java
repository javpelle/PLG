package lexjl;


import identifiersTable.IdentifiersTable;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jlAST.ASTNode;
import sinjl.AnalizadorSintactico;

public class Compilador {

	public static void main(String[] args) {
		ASTNode result = null;
		try {
			String file = "D:\\Luis\\Documents\\GitHub\\PLG\\CodEjemplo\\ej1.jl";
			AnalizadorSintactico asin = new AnalizadorSintactico(new AnalizadorLexico(new FileReader(file)));
			result = (ASTNode) asin.parse().value;
			System.out.println("Analisis lexico OK.");
			System.out.println("Analisis Sintactico OK.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		IdentifiersTable t = new IdentifiersTable();
		if (result.identifyNode(t)) {
			System.out.println("Fase de identificacion de identificadores OK.");
		} else {
			System.err.println("Error en fase de identificacion de identificadores.");
			return;
		}
		if (result.verifyTypes()) {
			System.out.println("Fase de chequeo de tipos OK.");
		} else {
			System.err.println("Error en fase de chequeo de tipos.");
			return;
		}
		try {
			FileWriter writer = new FileWriter(new File("ej1.p"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
