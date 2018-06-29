package jlAST.expresion;

public class Not extends Expresion {
	
	public Expresion e;

	public Not(Expresion e, int line, int col) {
		super(line, col);
		this.e = e;
	}

}
