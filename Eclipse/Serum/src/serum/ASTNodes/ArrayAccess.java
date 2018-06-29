package serum.ASTNodes;

import serum.IdTable;
import serum.Logger;
import serum.Type;
import serum.codegen.IndexArray;
import serum.codegen.PInstruction;

import java.util.List;

/**
 * @author jsevillamol
 */
public class ArrayAccess extends Variable {

    /**El array al que se está accediendo.*/
    private Variable reference;

    /**La posición del array a la que se accede.*/
    private Expression index;
    
    public ArrayAccess(Variable reference, Expression index){
        this.reference = reference;
        this.index = index;
    }
    
    @Override
    public Type getType(){ return this.reference.getType().getBaseType(); }

    @Override
    public List<PInstruction> toCodeL() {
        List<PInstruction> code = reference.toCodeL();
        code.addAll(index.toCode());
        code.add(new IndexArray(reference.getType().getBaseType().getSize()));
        //Los arrays empiezan por 0, no hay necesidad de decrementar.
        return code;
    }

    @Override
    public Boolean typeCheck() {
        Boolean res = index.typeCheck();
        if (!(reference.getType() instanceof Type.ArrayType)){
            String msg = "Type error. Expected ArrayType for array access declaration in line "
                    + row + ", column " + col + ". " + reference.getType() + " received";
            System.err.println(msg);
            Logger.log.println(msg);
            res = false;
        }
        if (!index.getType().equals(Type.TInt)){
            String msg = "Type error. Expected TInt for array access index in line "
                    + row + ", column "+ col + ". " + reference.getType() + " received";
            System.err.println(msg);
            Logger.log.println(msg);
            res = false;
        }
        return res; 
    }

    @Override
    public void identifiers(IdTable idTable) {
        reference.identifiers(idTable);
        index.identifiers(idTable);
    }
}
