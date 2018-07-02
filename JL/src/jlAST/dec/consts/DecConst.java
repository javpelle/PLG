package jlAST.dec.consts;

import java.util.ArrayList;

import codeGeneration.P;
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
	
	public int getSize() {
		return 1;
	}
	
	public ArrayList<P> generateCode() {
		return null;
	}
}
