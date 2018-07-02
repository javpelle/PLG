package jlAST.types;

public abstract class Type {
	
	/**
	 * Estos dos objetos constantes los utilizaremos para originar 
	 * y comparar los tipos primitivos
	 */
    public final static Type BoolType = new BoolType();
    public final static Type IntType = new IntType();
    
    protected int dimensiones;  //Cantidad de corchetes de la declaracion
 
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
	
	/**
	 * Quedará sobrescrito para arrays
	 * @return
	 */
	public int getSize() {
		return 1;
	}

	public abstract ArrayType createArray(int d);
	public abstract Type getType();
	
	/**
	 * Devuelve el tipo hijo, de un tipo dado.
	 * Si declaracion esv del tipo int[5][10] a, entonces devolvera int[10].
	 */
	public abstract Type getChildType();

}
