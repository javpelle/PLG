package jlAST.dec.consts;

import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class DecConstInt extends DecConst {
	private int value;
	private String id;
	private int rho;
	
	public DecConstInt(String id,int value, int line, int col) {
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
		return Type.IntType;
	}

	@Override
	public Type getPrimitiveType() {
		return Type.IntType;
	}
	
	@Override
	public int getRho() {
		return rho;
	}

	@Override
	public String getValue() {
		return Integer.toString(value);
	}
	
}
