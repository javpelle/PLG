package jlAST.expression;

import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class NotEq extends Expression {
	public Expression e1, e2;

	public NotEq (Expression e1, Expression e2, int line, int col) {
		super(line, col);
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public boolean identifyNode(IdentifiersTable t) {
		return e1.identifyNode(t) && e2.identifyNode(t);
	}
	
	@Override
	public Type getType() {
		return Type.BoolType;
	}

	@Override
	public boolean verifyTypes() {
		return e1.verifyTypes() && e2.verifyTypes()
				&& e1.getType().equals(e2.getType());
	}

}
