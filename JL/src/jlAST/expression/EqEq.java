package jlAST.expression;

import java.util.ArrayList;

import codeGeneration.EQU;
import codeGeneration.P;
import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class EqEq extends Expression {
	
	public Expression e1, e2;

	public EqEq(Expression e1, Expression e2, int line, int col) {
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
	
	@Override
	public ArrayList<P> generateCode() {
		ArrayList<P> list = e1.generateCode();
		list.addAll(e2.generateCode());
		list.add(new EQU());
		return list;
	}

}
