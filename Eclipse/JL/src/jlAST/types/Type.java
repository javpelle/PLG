package jlAST.types;

public abstract class Type {
	
    public final static Type BoolType = new BoolType();
    public final static Type IntType = new IntType();
    protected int dimensiones;

	protected int line;
	protected int col;

	protected Type () {}
	public Type(int line, int col) {
		this.line = line;
		this.col = col;
	}
	
	public int getDimensiones() {
		return dimensiones;
	}

	public abstract ArrayType createArray(int d);
	public abstract Type getType();

}
