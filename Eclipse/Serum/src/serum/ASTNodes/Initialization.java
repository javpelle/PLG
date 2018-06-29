package serum.ASTNodes;

import com.sun.istack.internal.NotNull;
import serum.IdTable;
import serum.Type;
import serum.codegen.LoadConstant;
import serum.codegen.PInstruction;
import serum.codegen.Store;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jsevillamol
 */
public class Initialization extends Declaration {

    /**Expresión que determina el valor a asignar.*/
    private Expression rhs;
    
    public Initialization(Type type, String id, Expression rhs) {
        super(type, id);
        this.rhs = rhs;
    }
    
    @Override
    public Boolean typeCheck() {
        Boolean res = rhs.typeCheck();
        if (!this.getType().equals(rhs.getType())){
            serum.Logger.report_error(
                    "Type error. Type declaration and rhs types of initialization in line " 
                    + row + " do not match. "
                    + " type declaration=" + this.getType()
                    + " rhs type=" + rhs.getType());
            res = false;
        }
        return res;
    }

    @NotNull
    @Override
    public List<PInstruction> toCode() {
        List<PInstruction> code = new LinkedList<>();
        code.add(new LoadConstant(this.getAddress()));
        code.addAll(rhs.toCode());
        code.add(new Store());
        return code;
    }

    @Override
    public void identifiers(IdTable idTable) {
        rhs.identifiers(idTable);
        super.identifiers(idTable);
    }
}
