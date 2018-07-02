package jlAST.types;

public class IntArrayType extends ArrayType {
	
	private Type t;
	private int dimension;
	
	/**
	 *Constructora utilizada en arrays de 
	 *dos o más dimensiones
	 */
	public IntArrayType(Type t, int dimension) {
		this.t = t;
		this.dimension = dimension;
		dimensiones = t.getDimensiones();
	}
	
	/**
	 *Constructora utilizada para crear la primera dimension del array
	 *incDimensiones siemppre vale 1
	 */
	public IntArrayType(Type t, int dimension, int incDimensiones) {
		this.t = t;
		this.dimension = dimension;
		dimensiones = incDimensiones;
	}

	
	/**
	 * Devuelve este mismo array pero con una dimension mas
	 */
	public ArrayType createArray(int d) {
		t = t.createArray(d);
		++dimensiones;
		return this;
	}
	
	public Type getType() {
		return Type.IntType;
	}
	
	@Override
	public Type getChildType() {
		return t;
	}
	
	public int getSize() {
		return dimension * t.getSize();
	}
	
	public boolean equals(Object o) {
		return o != null && o.getClass() == getClass()
				&& t.equals(((IntArrayType) o).t)
				&& dimension == ((IntArrayType) o).dimension;
	}

}
