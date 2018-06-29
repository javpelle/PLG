package jlAST;

public abstract class ASTNode {
	
	private int line;
	private int col;
	
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

}
