package identifiersTable;

import java.util.HashMap;

import jlAST.dec.Dec;

public class Scope {
	
	/**
	 * Contiene las declaraciones del ambito junto con su identificador.
	 */
	private HashMap<String, Dec> scope;
	
	/**
	 * Indica la direccion de memoria donde comienza el ambito.
	 */
    private int rho;
    
    public Scope(int availableRho) {
    	scope = new HashMap<String, Dec>();
    	rho = availableRho;
    }

    /**
     * Inserta una nueva declaracion
     * @param dec Nueva declaracion
     * @return True si exito.
     */
	public boolean insertDec(Dec dec) {
		// Verificamos que no exista ya la declaracion en el ambito.
		if (scope.containsKey(dec.getId())) {
			return false;
		}
		scope.put(dec.getId(), dec);
		return true;
	}
	
	
	public Dec get(String id) {
		return scope.get(id);
	}

	public int getRho() {
		return rho;
	}

}
