package jlAST.dec.consts;

import jlAST.ASTNode;
import jlAST.dec.Dec;

public abstract class DecConst extends ASTNode implements Dec {

	public DecConst(int line, int col) {
		super(line, col);
	}
	
	@Override
	public boolean verifyTypes() {
		return true;
	}
	
	@Override
	public boolean isConst() {
		return true;
	}
}
