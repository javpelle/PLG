package serum.ASTNodes;

import com.sun.istack.internal.NotNull;
import serum.IdTable;
import serum.codegen.PInstruction;
import java.util.List;

/**Interfaz que implementan todos los nodos del arbol de sintaxis abstracta.
 * Esta interfaz permite:
 *   ·Asignar fila y columna al nodo.
 *   ·Enlazar cada uso de variable con su declaración.
 *   ·Comprobar los tipos.
 *   ·Generar código.
 *
 *
 * @author jsevillamol, David Rubio
 */
public interface ASTNode {

    /**Especifica la fila y columna del archivo fuente en que se encuentra este nodo.*/
    void setRowAndCol(int row, int col);

    /**Asigna a cada variable del subarbol que tiene a este nodo como raiz su declaración.*/
    void identifiers(IdTable idTable);

    /**Comprueba que los tipos del subarbol de sintaxis abstracta que
     * tiene por raiz a este nodo sean correctos.*/
    Boolean typeCheck();

    /**@return Lista de p-instrucciones equivalentes
     * a la intrucción o expresión representada por este nodo*/
    @NotNull
    List<PInstruction> toCode();


}
