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
public class BinaryOp extends Expression {

    /**Primer operando.*/
    private Expression op1;

    /**Segundo operando.*/
    private Expression op2;

    /**Tipo de operacion*/
    private OperationType operationType;

    public BinaryOp(Expression op1, Expression op2, OperationType operationType){
        this.op1 = op1;
        this.op2 = op2;
        this.operationType = operationType;
    }


    @Override
    public void identifiers(IdTable idTable) {
        op1.identifiers(idTable);
        op2.identifiers(idTable);
    }

    @Override
    public Type getType() { return operationType.getResultType(); }

    @Override
    public Boolean typeCheck() {
        return op1.typeCheck() &&
               op2.typeCheck() &&
               checkOperator(op1.getType()) &&
               checkOperator(op2.getType());
    }

    /**Compruba si el tipo dado es el que debería corresponder a cada operador.
     * Si no muestra mensajes de error.*/
    private Boolean checkOperator(Type type) {
        if (!type.equals(operationType.getArgumentsType())) {
            String msg = "Type error. Expected " + operationType.getArgumentsType() +
                    " for left operand of binary operator in line " + row + ", column " +
                    col +". " + type + " received. Operation: " + operationType;
            serum.Logger.report_error(msg);
            return false;
        }
        return true;
    }

    @NotNull
    @Override
    public List<PInstruction> toCode() {
        List code = op1.toCode();
        code.addAll(op2.toCode());
        code.add(new POperation(operationType));
        return code;
    }

}
