package jlAST.expression;

import java.util.ArrayList;

import codeGeneration.CONST;
import codeGeneration.P;
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
	
	@Override
	public ArrayList<P> generateCode() {
		ArrayList<P> list = new ArrayList<P>();
		list.add(new CONST(Integer.toString(num)));
		return list;
	}
}
