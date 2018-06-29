package serum;

/**Este enumerado es para distinguir distintas operaciones.
 * Tiene una variable que indica el codigo a ejecutar y
 * metodos que indican el tipo del resultado y el tipo de los argumentos.
 * @author David Rubio
 */
public enum OperationType {
    SUM_OP  ("add"),
    SUBS_OP ("sub"),
    PROD_OP ("mul"),
    DIV_OP  ("div"),
    NEG_OP  ("neg"),
    EQ_OP   ("equ"),
    GET_OP  ("geq"),
    LET_OP  ("leq"),
    LT_OP   ("les"),
    GT_OP   ("grt"),
    NEQ_OP  ("neq"),
    AND_OP  ("and"),
    OR_OP   ("or" ),
    NOT_OP  ("not");

    /**Nombre de la p-instruccion correspondiente a la operación.*/
    public final String code;

    OperationType(String instruction) { this.code = instruction; }


    /**@return El tipo del resultado de la operación.*/
    public Type getResultType() {
        if (this.compareTo(NEG_OP) <= 0)
            return Type.TInt;
        else
            return Type.TBool;
    }

    /**@return El tipo de los argumentos de la operación.*/
    public Type getArgumentsType() {
        if (this.compareTo(NEQ_OP) <= 0)
            return Type.TInt;
        else
            return Type.TBool;
    }
}

