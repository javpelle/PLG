package jlAST.expression;

import java.util.ArrayList;

import codeGeneration.CONST;
import codeGeneration.P;
import jlAST.types.BoolType;
import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class BoolLiteral extends Expression {
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

	@Override
	public ArrayList<P> generateCode() {
		String b;
		if (bool) {
			b = "true";
		} else {
			b = "false";
		}
		ArrayList<P> list = new ArrayList<P>();
		list.add(new CONST(b));
		return list;
	}
}
