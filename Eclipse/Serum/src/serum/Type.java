package serum;

/**
 * Las instancias de esta clase son los distintos tipos que puede haber.
 *
 * @author jsevillamol, David Rubio
 */
public abstract class Type {

    /**Tipo básico de los booleanos.*/
    public final static Type TBool = new TBool();

    /**Tipo básico de los enteros.*/
    public final static Type TInt = new TInt();

    /**Devuelve el tipo de los elementos de este array.
     * Si no aplica lanza una excepción.*/
    public Type getBaseType() {
        //Something's gone wrong, ending execution:
        serum.Logger.report_error("Ending execution because illegal array access.");
        System.exit(4);
        return null;
    }

    /**@return El tamaño que ocupa un elemento de este tipo en memoria*/
    public int getSize() { return 1;}

    /**Crea un tipo array a partir de este con una dimensión más.
     * Este método puede modificar esta instancia.*/
    public ArrayType addDimension(int numberOfElements){
        return new ArrayType(this, numberOfElements);
    }

    public static class TBool extends Type{
        @Override
        public String toString() {return "TBool";}
    }

    public static class TInt  extends Type{
        @Override
        public String toString() {return "TInt";}
    }

    @Override
    public boolean equals(Object o) {
        return o!=null && o.getClass() == this.getClass();
    }

    
    public static class ArrayType extends Type{
        
        private Type baseType;
        private final int numberOfElements;
        
        ArrayType(Type baseType, int numberOfElements){
            this.baseType = baseType;
            this.numberOfElements = numberOfElements;
        }

        @Override
        public Type getBaseType(){return baseType;}

        @Override
        public int getSize(){ return numberOfElements * baseType.getSize();}

        @Override
        public boolean equals(Object o) {
            if (o==null || !(o instanceof ArrayType))
                return false;
            ArrayType arrayType = (ArrayType) o;
            return this.baseType.equals(arrayType.baseType) &&
                   this.numberOfElements == arrayType.numberOfElements;
        }

        @Override
        public ArrayType addDimension(int numberOfElements) {
            baseType = baseType.addDimension(numberOfElements);
            return this;
        }
    }

}
