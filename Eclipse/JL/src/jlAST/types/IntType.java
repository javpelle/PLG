package jlAST.types;

public class IntType extends Type {

	public IntType() {
		dimensiones = 0;
	}

	public ArrayType createArray(int d) {
		return new IntArrayType(this, d, 1);
	}
	
	public boolean equals(Object o) {
		return o != null && o.getClass() == getClass();
	}

	@Override
	public Type getType() {
		return this;
	}

}
