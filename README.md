# Procesador de lenguaje (compilador de JL)

## ¿Qué es **JL**?

**JL** es un lenguaje de programación muy simple basado en C desarrollado por Javier Pellejero y Luis Aguirre para la asignatura *Procesadores de Lenguaje* de la facultad de informática de la UCM.
A continuación podemos ver un ejemplo muy sencillo de llenado de un array de booleanos.

``` [C]
 main {
	decVar: {
		bool[10] b;
		int i;
	}
	i = 0;
	while (i < 10) {
		if (i < 5) {
			decVar: {
				bool a;
			}
			a = true;
			b[i] = a;
		} else {
			b[i]= false;
		}
		i = i + 1;
	}
}
 ```
 
 ## ¿Qué máquinas pueden ejecutar un programa escrito en **JL**?
 
 Si bien no recomendamos el uso de **JL** para escribir ningún tipo de programa por su simpleza y poca utilidad, si conviene echar un vistazo para entender cómo hemos realizado un compilador para este lenguaje.
 
 El compilador es para la *máquina P*, un intérprete realizado en Haskell y que utiliza una pila en lugar de registros.  
 La documentación necesaria para comprender el funcionomaciento de la máquina P está en la carpeta [máquina-P](https://github.com/javpelle/PLG/tree/master/maquina-P) y 
 el código de nuestro compilador está ligeramente comentado, así que recomendamos estudiar las diversas etapas y sus funcionamientos de un compilador antes de adentrarse en la lectura del código.
 
 Por último, añadir que **JL** podría funcionar en cualquier máquina siempre y cuando un compilador adecuado fuera realizado.
