public class Lista {

    private Integer[] lista = new Integer[10];
    private Integer tamanho = 0;

    public void add(Integer e){
        adicionaRecursivo(tamanho + 1, e);
    }

    public Integer adicionaRecursivo(Integer pos, Integer el){
        if(pos == 0){
            this.lista[pos] = el;
            this.tamanho ++;
            return null;
        }
        this.lista[pos] = this.lista[pos -1];
        adicionaRecursivo(pos-1, el);
        return null;

    }

    public void exibeLista(){
        for ( int i = 0; i < this.tamanho; i ++) {
                System.out.println(lista[i]);
        }
    }

}
