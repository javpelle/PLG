package jlAST.dec.decVar;

import identifiersTable.IdentifiersTable;
import jlAST.ASTNode;
import jlAST.dec.Dec;
import jlAST.types.Type;

public class DecVar extends ASTNode implements Dec {
	private Type t;
	private String id;
	private int rho;

	public DecVar(Type t, String id, int line, int col) {
		super(line, col);
		this.t = t;
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
			System.err.println("Error variable " + id
					+ " already declared in this scope. Line: " + getLine()
					+ ". Column: " + getCol() + ".");
			return false;
		}
		return true;
	}

	@Override
	public boolean isConst() {
		return false;
	}

	@Override
	public boolean verifyTypes() {
		return true;
	}

	@Override
	public Type getType() {
		return t;
	}
	
	public Type getPrimitiveType() {
		return t.getType();
	}
}
