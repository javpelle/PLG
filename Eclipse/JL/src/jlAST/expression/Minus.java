package jlAST.expression;

import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class Minus extends Expression {
	public Expression e1, e2;

	public Minus(Expression e1, Expression e2, int line, int col) {
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
		return Type.IntType;
	}

	@Override
	public boolean verifyTypes() {
		return e1.verifyTypes() && e2.verifyTypes()
				&& e1.getType().equals(Type.IntType)
				&& e2.getType().equals(Type.IntType);
	}

}
