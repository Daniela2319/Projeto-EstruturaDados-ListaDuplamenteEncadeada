package ListaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista;

    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index){ // método vai fazer reaproveitamentos dos códigos do método getNo
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento){ // método add não recebe nem indice somente contéudo novoNo é o elemento
        NoDuplo<T> novoNo = new NoDuplo<>(elemento); //instancia do NoDuplo vai ser o novoNo na lista passa o elemento
        novoNo.setNoProximo(null); // configura novoNo no final da lista duplamente encadeada vai apontar para nulo, a sua referência proximoNo não tem ninguem a sua frente.
        novoNo.setNoPrevio(ultimoNo); // novoNo aponta para últimoNo porque ultimoNo aponta para o antigo ultimoNo da lista. Como agora o ultimoNo da lista novoNo.
        if(primeiroNo == null){ // realizado as condições: se o primeiroNo igual a nulo se for primeiroNo sera igual novoNo
            primeiroNo = novoNo;
        }
        if (ultimoNo != null){ // se ultimoNo for diferente e igual nulo novoNo será o ultimoNo.
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo; // se for true ultimoNo sera novoNo.
        tamanhoLista++;
    }

    private NoDuplo<T> getNo(int index){ // método getNo declarado privado
        NoDuplo<T> noAuxiliar = primeiroNo; // NoDuplo declara noAuxiliar se refere primeiroNo
        for (int i = 0; (i < index) && (noAuxiliar != null); i++){ //duas condições de parada
            noAuxiliar = noAuxiliar.getNoProximo(); // Quando for se true o laço estara correndo, se não ele quebra.
        }
        return noAuxiliar; // loop termina retorno noAuxiliar
    }

    public int size(){
        return this.tamanhoLista;
    }

}
