package jlAST.expression;

import jlAST.dec.Dec;
import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class Variable extends Expression {
	private String s;
	private Dec dec;
	protected int dimensiones;

	protected Variable() {
		dimensiones = 0;
	}

	public Variable(String s, int line, int col) {
		super(line, col);
		this.s = s;
		dimensiones = 0;
	}

	public String toString() {
		return s;
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		dec = t.buscaId(s);
		if (dec == null) {
			System.err.println("Error Indentifier " + s	+
					" not declared. Line: " + getLine() + ". Column: " + getCol() + ".");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean verifyTypes() {
		return dec.getType().getDimensiones() == 0;
	}

	@Override
	public Type getType() {
		return dec.getType();
	}
	
	public Type getPrimitiveType() {
		return dec.getPrimitiveType();
	}

	
	public int getTypeDimensiones() {
		return dec.getType().getDimensiones();
	}
	
	public boolean isConst() {
		return dec.isConst();
	}

	public int getDimensiones() {
		return dimensiones;
	}
	
}
