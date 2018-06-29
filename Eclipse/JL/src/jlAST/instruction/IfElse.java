package jlAST.instruction;

import jlAST.expresion.Expresion;

public class IfElse extends If {
	private Instruction iElse;

	public IfElse(Expresion e, Instruction i, Instruction iElse, int line, int col) {
		super(e, i, line, col);
		this.iElse = iElse;
	}

}
