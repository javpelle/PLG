package jlAST;

import identifiersTable.IdentifiersTable;

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
	
	abstract public boolean identifyNode(IdentifiersTable t);
	
	abstract public boolean verifyTypes();

}
