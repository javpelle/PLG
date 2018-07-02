package jlAST.types;

public class IntType extends Type {

	public IntType() {
		dimensiones = 0;
	}

	public ArrayType createArray(int d) {
		return new IntArrayType(this, d, 1);
	}
	
	/**
	 * Para la comprobacion estructural. No la llegamos a usar
	 */
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
