package jlAST.types;

public class BoolType extends Type {

	public BoolType() {
		dimensiones = 0;
	}
	
	public BoolArrayType createArray(int d) {
		return new BoolArrayType(this, d, 1);
	}
	
	public boolean equals(Object o) {
		return o != null && o.getClass() == getClass();
	}

	@Override
	public Type getType() {
		return this;
	}
	
	@Override
	public Type getChildType() {
		return null;
	}

}
