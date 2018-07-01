package jlAST.expression;

import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class IntegerLiteral extends Expression {
	private int num;

	public IntegerLiteral(int num, int line, int col) {
		super(line, col);
		this.num = num;
	}
	
	@Override
	public boolean identifyNode(IdentifiersTable t) {
		return true;
	}

	@Override
	public Type getType() {
		return Type.IntType;
	}

	@Override
	public boolean verifyTypes() {
		return true;
	}
}
