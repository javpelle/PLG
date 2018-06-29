package serum.ASTNodes;

import com.sun.istack.internal.NotNull;
import serum.IdTable;
import serum.Typable;
import serum.Type;
import serum.codegen.PInstruction;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jsevillamol
 */
public class Declaration extends Instruction implements Typable {

    /**Nombre de la variable declarada.*/
    private String id;

    /**Tipo de la variable declarada.*/
    private Type type;

    /**Dirección de memoria de la variable declarada.*/
    private int address;
    
    public Declaration(Type type, String id){
        this.id = id;
        this.type = type;
    }

    /**@return El nombre de la variable declarada.*/
    public String getId(){return id;}

    /**@return La dirección de la variable declarada.*/
    public int getAddress() { return address; }

    @Override
    public Type getType(){return type;}
    
    @Override
    public Boolean typeCheck() { return true; }

    @NotNull
    @Override
    public List<PInstruction> toCode() {return new LinkedList<>();}

    @Override
    public void identifiers(IdTable idTable) { address = idTable.insertDeclaration(this); }
}
