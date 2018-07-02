package jlAST.expression;

import java.util.ArrayList;

import codeGeneration.LES;
import codeGeneration.P;
import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class Lt extends Expression {
	
	public Expression e1, e2;

	public Lt(Expression e1, Expression e2, int line, int col) {
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
				&& e1.getType().equals(Type.IntType)
				&& e2.getType().equals(Type.IntType);
	}
	
	@Override
	public ArrayList<P> generateCode() {
		ArrayList<P> list = e1.generateCode();
		list.addAll(e2.generateCode());
		list.add(new LES());
		return list;
	}

}
