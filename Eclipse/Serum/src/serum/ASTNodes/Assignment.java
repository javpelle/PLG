package serum.ASTNodes;

import com.sun.istack.internal.NotNull;
import serum.IdTable;
import serum.Logger;
import serum.codegen.PInstruction;
import serum.codegen.Store;

import java.util.List;

/**
 *
 * @author jsevillamol
 */
public class Assignment extends Instruction {

    /**Variable a la que se le está asignando un valor.*/
    private Variable lhs;

    /**Expresión que determina el valor a asignar.*/
    private Expression rhs;
    
    public Assignment(Variable lhs, Expression rhs){
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @NotNull
    @Override
    public List<PInstruction> toCode() {
        List<PInstruction> code = lhs.toCodeL();
        code.addAll(rhs.toCode());
        code.add(new Store());
        return code;
    }

    @Override
    public Boolean typeCheck() {
        Boolean res = lhs.typeCheck() && rhs.typeCheck();
        if (!(lhs.getType().equals(rhs.getType()))){
            String msg = "Type error. lhs and rhs types of assignment in line "
                    + row + " do not match. "
                    + " lhs type=" + lhs.getType()
                    + " rhs type=" + rhs.getType();
            serum.Logger.report_error(msg);
            res = false;
        }
        return res;
    }

    @Override
    public void identifiers(IdTable idTable) {
        lhs.identifiers(idTable);
        rhs.identifiers(idTable);
    }


}
