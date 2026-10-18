# Tarea 17 - Contador de caracteres

## Alumno

- Anxo Vázquez Lorenzo

## Asignatura

- PSP - 2DAM

## Estructura del proyecto

- `Main.java` -> Lanzador del programa

- `ficheros/` -> lugar del texto a recorrer

- `ContadorChar` -> Clase que sirve como contador tanto global como independiente (de cada caracter)

- `RecorrerTexto` -> Clase encargada en recorrer letra por letra el texto

## Clase `ContadorChar`

Esta clase contiene un `lock` a nivel de Objeto en su método `incrementar` que restringe su uso a los hilos que intenten acceder a esa sección del método **de la misma instancia**, es decir si dos hilos intentar incrementar el contador de la mismma instancia los va a restringir (esperar a que uno termine para incrementar el otro), pero si dos hilos intentan usar ese método de **dos instancias distintas** no se bloquearan. En caso del contador global se restringuirá el acceso a los 5 hilos.

```java
public class ContadorChar {
    private int contador = 0;
    private final Object lock = new Object();

    public void incrementar(){
        synchronized (lock) {
            this.contador += 1;
        }
    }

    public int getContador(){
        return this.contador;
    }
}

```

También se podría hacer un `synchronized` a nivel del método y funcionaría igual para este caso.

```java
//se elimina el objeto candado
synchronized public void incrementar(){
            this.contador += 1;

       

    } 
```

## Bibliografía

- Geeksforgeeks - FileInputStream Java
  https://www.geeksforgeeks.org/java/java-fileinputstream-read-method-with-examples/
