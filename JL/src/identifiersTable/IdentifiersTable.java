package identifiersTable;

import java.util.ArrayList;

import jlAST.dec.Dec;

public class IdentifiersTable {
	
	//Lista con los ambitos.
	private ArrayList<Scope> list;
	
	//Primera rho disponible
	private int availableRho;
	
	//Maxima rho para la instruccion ssp
	private int maxSizeStack;
	
	public IdentifiersTable() {
		list = new ArrayList<Scope>();
		availableRho = 5;
		maxSizeStack = 5;
	}

	public void abreBloque() {
		list.add(new Scope(availableRho));
	}
	
	public void cierraBloque() {
		availableRho = list.get(list.size() - 1).getRho();
		list.remove(list.size() - 1);
    }
	
	/**
	 * Insertamos la declaracion de variable en la tabla
	 * @param Declaracion
	 * @return Rho asociada a la declaracion de la variable
	 */
	public int insertaId (Dec dec) {
		if(list.get(list.size() - 1).insertDec(dec)) {
			if (list.size() == 1) {
				// Esto significa que estamos en el ambito cero y solo
				// podemos declarar constantes. No queremos asignarles 
				// Direcciones de memoria, mandamos 0 por defecto
				// o -1 sy hay constante repetida.
				return 0;
			}
			int aux = availableRho;
			availableRho += dec.getSize();
			if (availableRho > maxSizeStack) {
				maxSizeStack = availableRho;
			}
			return aux;
		}
		// Ya existe la variable en ese ambito.
		return -1;
	}
	
	/**
	 * Recorremos los ambitos de mas interno a mas externo en busca del identificador
	 * @param Identificador
	 * @return Declaracion asociada al identificador
	 */
	public Dec buscaId(String id) {
		for (int i = list.size() - 1; i >= 0; --i) {
			Dec dec = list.get(i).get(id);
            if (dec != null) {
            	return dec;
            }	
		}
        return null;
	}
	
	public int getMaxSizeStack() {
		return maxSizeStack;
	}

}
