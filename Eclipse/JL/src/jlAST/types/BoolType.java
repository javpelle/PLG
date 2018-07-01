package jlAST.types;

public class BoolType extends Type {

	public BoolType() {
		dimensiones = 0;
	}
	
	public BoolArrayType createArray(int d) {
		return new BoolArrayType(this, d);
	}
	
	public boolean equals(Object o) {
		return o != null && o.getClass() == getClass();
	}

	@Override
	public Type getType() {
		return this;
	}

}
