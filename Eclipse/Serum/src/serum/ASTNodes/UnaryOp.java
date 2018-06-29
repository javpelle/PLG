package serum.ASTNodes;

import com.sun.istack.internal.NotNull;
import serum.IdTable;
import serum.OperationType;
import serum.Type;
import serum.codegen.PInstruction;
import serum.codegen.POperation;

import java.util.List;

/**
 * @author jsevillamol, David Rubio
 */
public class UnaryOp extends Expression {

    /**Expresión que da el valor al que aplicar la operación.*/
    private Expression expression;

    /**Tipo de operación a aplicar.*/
    private OperationType operationType;
    
    public UnaryOp(Expression op1, OperationType opType){
        this.expression = op1;
        this.operationType = opType;
    }

    @Override
    public Type getType() { return operationType.getResultType(); }

    @NotNull
    @Override
    public List<PInstruction> toCode() {
        List<PInstruction> code = expression.toCode();
        code.add(new POperation(operationType));
        return code;
    }

    @Override
    public Boolean typeCheck() {
        if (!expression.getType().equals(operationType.getArgumentsType())){
            serum.Logger.report_error(
                    "Type error. Expected " + operationType.getArgumentsType() +
                    " for operand of unary operator in line "
                    + row + ", " + expression.getType() + " received.");
            return false;
        }
        return true;
    }

    @Override
    public void identifiers(IdTable idTable) {
        expression.identifiers(idTable);
    }
}