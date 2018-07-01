package jlAST.expression;

import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class Not extends Expression {
	
	public Expression e;

	public Not(Expression e, int line, int col) {
		super(line, col);
		this.e = e;
	}
	
	@Override
	public boolean identifyNode(IdentifiersTable t) {
		return e.identifyNode(t);
	}
	
	@Override
	public Type getType() {
		return Type.BoolType;
	}

	@Override
	public boolean verifyTypes() {
		return e.verifyTypes() && e.getType().equals(Type.BoolType);
	}

}
