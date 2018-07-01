package jlAST.types;

public class BoolArrayType extends ArrayType {

	private Type t;
	private int dimension;

	public BoolArrayType(Type t, int dimension) {
		this.t = t;
		this.dimension = dimension;
		dimensiones = t.getDimensiones();
	}
	
	@Override
	public ArrayType createArray(int d) {
		t = new BoolArrayType(t, d);
		++dimensiones;
		return this;
	}

	public Type getType() {
		return Type.BoolType;
	}

	public boolean equals(Object o) {
		return o != null && o.getClass() == getClass()
				&& t.equals(((BoolArrayType) o).t)
				&& dimension == ((BoolArrayType) o).dimension;
	}
}
