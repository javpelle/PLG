package serum.ASTNodes;

import com.sun.istack.internal.NotNull;
import serum.IdTable;
import serum.Type;
import serum.codegen.LoadConstant;
import serum.codegen.PInstruction;

import java.util.LinkedList;
import java.util.List;

/**@author jsevillamol
 */
public class Constant extends Expression{

    /**Tipo de la constante.*/
    private Type type;

    /**Valor de la constante.*/
    private Object value;

    /**Crea una sontatnte con el tipo y valor dado.*/
    private Constant(Type type, Object value){
        this.type = type;
        this.value = value;
    }

    /**Crea una constante entera con el valor dado.*/
    public Constant(Integer value){
        this(Type.TInt, value);
    }

    /**Crea una constante booleana con el valor dado.*/
    public Constant(Boolean value){
        this(Type.TBool, value);
    }

    @Override
    public Type getType() { return type; }

    @NotNull
    @Override
    public List<PInstruction> toCode() {
        List<PInstruction> code = new LinkedList<>();
        if (value instanceof Integer)
            code.add(new LoadConstant((Integer) value));
        else if (value instanceof Boolean)
            code.add(new LoadConstant((Boolean) value));
        else
            serum.Logger.report_error("Constant value not an Integer or Boolean.");
        return code;
    }

    @Override
    public Boolean typeCheck() { return true; }

    @Override
    public void identifiers(IdTable idTable) {}
}
