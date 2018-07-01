package jlAST.types;

public class IntArrayType extends ArrayType {
	
	private Type t;
	private int dimension;

	public IntArrayType(Type t, int dimension) {
		this.t = t;
		this.dimension = dimension;
		dimensiones = t.getDimensiones();
	}
	
	public IntArrayType(Type t, int dimension, int incDimensiones) {
		this.t = t;
		this.dimension = dimension;
		dimensiones = incDimensiones;
	}

	@Override
	public ArrayType createArray(int d) {
		t = new IntArrayType(t, d);
		++dimensiones;
		return this;
	}
	
	public Type getType() {
		return Type.IntType;
	}
	
	public boolean equals(Object o) {
		return o != null && o.getClass() == getClass()
				&& t.equals(((IntArrayType) o).t)
				&& dimension == ((IntArrayType) o).dimension;
	}

}
