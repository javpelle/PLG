package jlAST;

import java.util.ArrayList;

import codeGeneration.P;
import identifiersTable.IdentifiersTable;


/**
 * Nodo del arbol abstracto. Linea y columna para senalizacion de errores.
 */
public abstract class ASTNode {
	
	private int line;
	private int col;
	
	/**
	 * Constructora para objetos del tipo array (no queremos fila y columna repetidas)
	 * de tipo BoolLietral, IntegerLiteral (constantes en expresiones).
	 */
	protected ASTNode() {}
	
	public ASTNode (int line, int col) {
		this.line = line;
		this.col = col;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getCol() {
		return col;
	}
	
	/**
	 * Comprueba si todos los identificadores que se encuentran
	 * a partir de un nodo son correctos. 
	 * @param t Tabla de Identificacion de Identificadores.
	 * @return True si todo correcto.
	 */
	abstract public boolean identifyNode(IdentifiersTable t);
	
	/**
	 * Comprueba si todos los tipos que se encuentran
	 * a partir de un nodo son correctos. 
	 * @return True si todo correcto.
	 */
	abstract public boolean verifyTypes();
	
	/**
	 * Genera las instrucciones de un nodo y de sus hijos.
	 * @return Instrucciones de codigo P
	 */
	abstract public ArrayList<P> generateCode();

}
