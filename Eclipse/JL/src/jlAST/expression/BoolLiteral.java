package jlAST.expression;

import jlAST.types.BoolType;
import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class BoolLiteral extends Expression{
	private boolean bool;

	public BoolLiteral(boolean bool, int line, int col) {
		super(line, col);
		this.bool = bool;
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		return true;
	}

	@Override
	public Type getType() {
		return new BoolType();
	}

	@Override
	public boolean verifyTypes() {
		return true;
	}
}
