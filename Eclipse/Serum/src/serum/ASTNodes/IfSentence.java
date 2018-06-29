package serum.ASTNodes;

import com.sun.istack.internal.NotNull;
import serum.IdTable;
import serum.Type;
import serum.codegen.Jump;
import serum.codegen.PInstruction;

import java.util.List;

/**
 * @author jsevillamol, David Rubio
 */
public class IfSentence extends Instruction {

    /**Condicion booleana del if.*/
    private Expression condition;

    /**Instrucción a ejecutar si se verifica la condición.*/
    private Instruction body;
    
    public IfSentence(Expression condition, Instruction conditional){
        this.condition = condition;
        this.body = conditional;
    }

    @NotNull
    @Override
    public List<PInstruction> toCode() {
        List<PInstruction> code = condition.toCode();
        List<PInstruction> ifCode = body.toCode();
        code.add(new Jump(ifCode.get(ifCode.size()-1),
                          true/*condicional*/,
                          false/*a la instruccion que sigue a la dada*/));
        code.addAll(ifCode);
        return code;
    }

    @Override
    public Boolean typeCheck() {
        Boolean res = condition.typeCheck() && body.typeCheck();
        if (!condition.getType().equals(Type.TBool)){
            serum.Logger.report_error(
                    "Type error. Expected TBool for if condition in line " 
                    + row + ", " + condition.getType() + " received");
            res = false;
        }
        return res;
    }

    @Override
    public void identifiers(IdTable idTable) {
        condition.identifiers(idTable);
        body.identifiers(idTable);
    }
}
