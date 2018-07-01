package jlAST.expression;


import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class ArrayVar extends Variable {

	private Variable id;
	private Expression e;
	// Dec
	public ArrayVar(Variable id, Expression e) {
		this.id = id;
		this.e = e;
		dimensiones = id.getDimensiones() + 1;
	}
	
	public Type getType() {
		return id.getType();
	}
	
	@Override
	public boolean identifyNode(IdentifiersTable t) {
		return id.identifyNode(t) && e.identifyNode(t);
	}
	
	public boolean isConst() {
		return false;
	}
	
	public int getTypeDimensiones() {
		return id.getTypeDimensiones();
	}
	
	public boolean verifyTypes() {
		return e.getType().equals(Type.IntType) && dimensiones == getTypeDimensiones();
	}
	
	public Type getPrimitiveType() {
		return id.getPrimitiveType();
	}
	
}