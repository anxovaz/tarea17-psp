public class RecorrerTexto {
    public String texto;
    public char caracter;
    public ContadorChar contadorLocal = new ContadorChar();
    public RecorrerTexto(char c, String texto){
        this.texto = texto;
        this.caracter = c;
    }
    public void contarCaracter(ContadorChar cGlobal){
        for(int i = 0; i<this.texto.length();i++){
           if(this.texto.charAt(i) == this.caracter){
               cGlobal.incrementar();
               this.contadorLocal.incrementar();
           }
        }
    }
    public int getContadorLocal(){
        return this.contadorLocal.getContador();
    }


}
