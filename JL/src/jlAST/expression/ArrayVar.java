package jlAST.expression;

import java.util.ArrayList;

import codeGeneration.IND;
import codeGeneration.IXA;
import codeGeneration.P;
import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class ArrayVar extends Variable {

	private Variable id;
	private Expression e;

	public ArrayVar(Variable id, Expression e) {
		this.id = id;
		this.e = e;
		dimensiones = id.getDimensiones() + 1;
	}
	
	/**
	 * Devuelve el tipo base de la variable.
	 * Por ejemplo, si a[2][3] hace referencia a una declaracion
	 * del tipo int[5][5] a, entonces devolvera int.
	 */
	public Type getType() {
		return id.getType();
	}
	
	/**
	 * Funcion auxiliar para el calculo del argumento de la
	 * instruccion P ixa. Si a[2][3] hace referencia a una declaracion
	 * del tipo int[5][10] a, entonces devolvera int[10].
	 */
	public Type getTypeIxa() {
		return id.getTypeIxa().getChildType();
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		return id.identifyNode(t) && e.identifyNode(t);
	}
	
	/**
	 * Siempre falso pues no permtimos constantes de tipo array.
	 */
	public boolean isConst() {
		return false;
	}
	
	/**
	 * Devuelve las dimensiones de la declaracion a la que esta variable
	 * hace referencia.
	 */
	public int getTypeDimensiones() {
		return id.getTypeDimensiones();
	}
	
	/**
	 * Verifica que todas las expresiones de todos los corchetes son corrctas
	 * y de tipo entero.
	 */
	public boolean verifyExpression() {
		return e.getType().equals(Type.IntType) && id.verifyExpression();
	}
	
	/**
	 * Verifica que la variable hace referencia a una declaracion de manera correcta.
	 * Es decir con el mismo numero de "corchetes" que dimensiones y con
	 * el contenido de los corchetes correcto y de tipo entero.
	 */
	public boolean verifyTypes() {
		return verifyExpression() && dimensiones == getTypeDimensiones();
	}

	public int getLine() {
		return id.getLine();
	}

	public int getCol() {
		return id.getCol();
	}

	@Override
	public ArrayList<P> generateCode() {
		ArrayList<P> list = new ArrayList<P>();
		list.addAll(generateCodeLeft());
		list.add(new IND());
		return list;
	}
	
	/**
	 * Función auxiliar para la creacion de codigo de llamadas a arrays.
	 */
	public ArrayList<P> generateCodeLeft() {
		ArrayList<P> list = id.generateCodeLeft();
		list.addAll(e.generateCode());
		list.add(new IXA(getTypeIxa().getSize()));
		return list;
	}

}