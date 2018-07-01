package jlAST.instruction;

import jlAST.ASTNode;

public abstract class Instruction  extends ASTNode {

	public Instruction(int line, int col) {
		super(line, col);
	}

}
