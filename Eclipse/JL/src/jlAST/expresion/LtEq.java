package jlAST.expresion;

public class LtEq extends Expresion {
	public Expresion e1, e2;

	public LtEq(Expresion e1, Expresion e2, int line, int col) {
		super(line, col);
		this.e1 = e1;
		this.e2 = e2;
	}

}
