package identifiersTable;

import java.util.HashMap;

import jlAST.dec.Dec;

public class Scope {
	
	private HashMap<String, Dec> scope;

    private Integer rho;
    
    public Scope() {
    	scope = new HashMap<String, Dec>();
    }

	public boolean insertDec(Dec dec) {
		if (scope.containsKey(dec.getId())) {
			return false;
		}
		scope.put(dec.getId(), dec);
		return true;
	}

	public Dec get(String id) {
		return scope.get(id);
	}

}
