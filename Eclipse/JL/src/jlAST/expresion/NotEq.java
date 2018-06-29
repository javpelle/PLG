package jlAST.expresion;

public class NotEq extends Expresion {
	public Expresion e1, e2;

	public NotEq (Expresion e1, Expresion e2, int line, int col) {
		super(line, col);
		this.e1 = e1;
		this.e2 = e2;
	}

}
