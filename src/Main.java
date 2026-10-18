import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        int numMultiplicacionesTexto = 2000;
        String texto = "";
        ContadorChar contadorGlobal = new ContadorChar();
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        System.out.println("¿Deseas usar un texto propio (p) o quieres usar el del archivo ficheros/texto.txt (a)?");
        String opcion = sc.next();
        if (opcion.toLowerCase().compareTo("p") == 0){
            System.out.println("Introduce texto (se multiplicará por " + numMultiplicacionesTexto + ")");
            texto = sc.next().repeat(numMultiplicacionesTexto);
        }else{ //asumo que quiere usar el de texto.txt
            System.out.println("Usando el texto del fichero (multiplicado por )" + numMultiplicacionesTexto + ")");
            texto = devolverTexto(new File("./ficheros/texto.txt")).repeat(2000);
        }

        System.out.println("=====");

        System.out.println("Introduce caracter para r1:");
        RecorrerTexto r1 = new RecorrerTexto(sc.next().charAt(0), texto);
        Thread thread1 = new Thread(() -> r1.contarCaracter(contadorGlobal));

        System.out.println("Introduce caracter para r2:");
        RecorrerTexto r2 = new RecorrerTexto(sc.next().charAt(0), texto);
        Thread thread2 = new Thread(() -> r2.contarCaracter(contadorGlobal));

        System.out.println("Introduce caracter para r3:");
        RecorrerTexto r3 = new RecorrerTexto(sc.next().charAt(0), texto);
        Thread thread3 = new Thread(() -> r3.contarCaracter(contadorGlobal));

        System.out.println("Introduce caracter para r4:");
        RecorrerTexto r4 = new RecorrerTexto(sc.next().charAt(0), texto);
        Thread thread4 = new Thread(() -> r4.contarCaracter(contadorGlobal));

        System.out.println("Introduce caracter para r5:");
        RecorrerTexto r5 = new RecorrerTexto(sc.next().charAt(0), texto);
        Thread thread5 = new Thread(() -> r5.contarCaracter(contadorGlobal));

        System.out.println("Arrancando los procesos...");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();

        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        System.out.println("===RESULTADOS====");

        System.out.println("Contador global: " + contadorGlobal.getContador());
        System.out.println("r1: " + r1.contadorLocal.getContador());
        System.out.println("r2: " + r2.contadorLocal.getContador());
        System.out.println("r3: " + r3.contadorLocal.getContador());
        System.out.println("r4: " + r4.contadorLocal.getContador());
        System.out.println("r5: " + r5.contadorLocal.getContador());

    }
    public static String devolverTexto(File file) {
        String texto = "";
        try(FileInputStream fis = new FileInputStream(file)){
            int i = 0;
            while((i = fis.read()) != -1){
                texto = texto + ((char) i);

            }
            return texto;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}