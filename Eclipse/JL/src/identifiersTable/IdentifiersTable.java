package identifiersTable;

import java.util.ArrayList;
import java.util.HashMap;

import jlAST.dec.Dec;

public class IdentifiersTable {

	private ArrayList<Scope> list;
	
	public IdentifiersTable() {
		list = new ArrayList<Scope>();
	}

	public void abreBloque() {
		list.add(new Scope());
	}
	
	public void cierraBloque() {
		list.remove(list.size() - 1);
    }
	
	public int insertaId (Dec dec) {
		if(list.get(list.size() - 1).insertDec(dec)) {
			return 0;
		}
		// Ya existe la variable en ese ambito.
		return -1;
	}
	
	public Dec buscaId(String id) {
		for (Scope scope : list) {
            Dec dec = scope.get(id);
            if (dec != null)
                return dec;
        }
        return null;
	}

}
