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
public class IfElseSentence extends Instruction{

    /**Condicion booleana del if.*/
    private Expression condition;

    /**Instrucción a ejecutar si se verifica la condición.*/
    private Instruction ifBranch;

    /**Instruccion a ejecutar si no se verifica la condición.*/
    private Instruction elseBranch;
    
    public IfElseSentence(Expression condition, Instruction ifBranch, Instruction elseBranch){
        this.condition = condition;
        this.ifBranch = ifBranch;
        this.elseBranch = elseBranch;
    }

    @NotNull
    @Override
    public List<PInstruction> toCode() {
        List<PInstruction> code = condition.toCode();
        List<PInstruction> elseCode = elseBranch.toCode();
        code.add(new Jump(elseCode.get(0),
                          true/*condicional*/,
                          true/*salto a la instruccion dada*/));
        code.addAll(ifBranch.toCode());
        code.add(new Jump(elseCode.get(elseCode.size()-1),
                          false/*incondicional*/,
                          false/*salto a la instruccion que sigue a la dada*/));
        code.addAll(elseCode);
        return code;
    }

    @Override
    public Boolean typeCheck() {
        Boolean res = condition.typeCheck() && ifBranch.typeCheck() && elseBranch.typeCheck();
        if (!condition.getType().equals(Type.TBool)){
            serum.Logger.report_error(
                    "Type error. Expected TBool for if-else condition in line " 
                    + row + ", " + condition.getType() + " received");
            res = false;
        }
        return res;
    }

    @Override
    public void identifiers(IdTable idTable) {
        condition.identifiers(idTable);
        ifBranch.identifiers(idTable);
        elseBranch.identifiers(idTable);
    }
}
