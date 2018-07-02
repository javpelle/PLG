package jlAST.dec.decVar;

import java.util.ArrayList;

import codeGeneration.P;
import identifiersTable.IdentifiersTable;
import jlAST.ASTNode;
import jlAST.dec.Dec;
import jlAST.types.Type;

public class DecVar extends ASTNode implements Dec {
	
	private Type t;  //Tipo de la variable
	private String id; //Identificador de la variable
	private int rho; //Direccion de memoria de la variable

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
	
	public int getSize() {
		return t.getSize();
	}

	@Override
	public ArrayList<P> generateCode() {
		return null;
	}

	@Override
	public int getRho() {
		return rho;
	}

	@Override
	public String getValue() {
		// Este metodo solo es llamado si la variable es CONST
		// Es decir, nunca ejecutaremos estas lineas de codigo.
		return null;
	}
}
