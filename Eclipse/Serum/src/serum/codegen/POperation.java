package serum.codegen;

import serum.OperationType;

/**Esta clase representa las operaciones aritmeticas y booleanas.
 * @author David Rubio
 */
public class POperation extends PInstruction{

    /**Tipo de operación a ejecutar.*/
    private OperationType operationType;

    public POperation(OperationType opType) { this.operationType = opType; }

    @Override
    public String toString() { return super.toString() + operationType.code + ";\n"; }
}
