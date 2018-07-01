package jlAST.dec.consts;

import jlAST.types.BoolType;
import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class DecConstBool extends DecConst {
	private boolean value;
	private String id;
	private int rho;

	public DecConstBool(String id, boolean value, int line, int col) {
		super(line, col);
		this.value = value;
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		rho = t.insertaId(this);
		if (rho == -1) {
			System.err.println("Error constant " + id
					+ " already declared in this scope. Line: " + getLine()
					+ ". Column: " + getCol() + ".");
			return false;
		}
		return true;
	}

	@Override
	public Type getType() {
		return Type.BoolType;
	}

	@Override
	public Type getPrimitiveType() {
		return Type.BoolType;
	}
	
}
