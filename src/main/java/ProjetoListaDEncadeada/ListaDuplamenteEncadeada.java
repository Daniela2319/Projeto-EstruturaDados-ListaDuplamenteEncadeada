package ProjetoListaDEncadeada;


/**
 * Representa classe ListaDuplamenteEncadeada é implementação dos métodos
 * @param <T> classe Generica
 */
public class ListaDuplamenteEncadeada<T> {

    //Atributos
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista;

    //Construtor
    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    /**
     * Método get
     * @param index adiciona um índice na lista
     * @return
     */
    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    /**
     * Método add
     * @param elemento adiciona na lista
     * @apiNote Instancia no código que representa um elemento e faz a verificação se lista esta nula antes e a pos o elemento.
     */
    public void add(T elemento){
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

    /**
     * Método add sobre carga
     * @param index escolhe indice e adicionar novo elemento
     * @param elemento adiciona o elemento
     * @apiNote Realizado o teste de verificação(if e else) se a lista esta nula para indice e para o elemento.
     */
    public void add(int index, T elemento){
        NoDuplo<T> noAuxiliar = getNo(index); // cria se noAuxilar é reutilizado método getNo passa pelo índice
        NoDuplo<T> novoNo = new NoDuplo<T>(elemento); // novoNo é inserido na lista passando por elemento
        novoNo.setNoProximo(noAuxiliar); // novoNo set proximo nó é noAuxiliar

        if (novoNo.getNoProximo() != null){ // testa se novoNo é diferente de nulo
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        }else {
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }
        if (index == 0){
            primeiroNo = novoNo;
        }else {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
        tamanhoLista++;
    }

    /**
     * Método remove
     * @param index indice é escolhido para ser removido da lista.
     * @apiNote É realizado a verificação(if e else) se a lista está nula, também desligamento das suas referências antes e depois.
     */
    public void remove(int index){
        if (index == 0){
            primeiroNo = primeiroNo.getNoProximo();
            if (primeiroNo != null){
                primeiroNo.setNoPrevio(null);
            }
        } else{
           NoDuplo<T> noAuxiliar = getNo(index);
           noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo()); // desligamento antes

           if (noAuxiliar != ultimoNo){
               noAuxiliar.getNoProximo().setNoProximo(noAuxiliar.getNoPrevio()); // desligamento pós
           }else {
               ultimoNo = noAuxiliar;
           }
        }
        this.tamanhoLista--;

    }

    /**
     * Método getNo
     * @param index reaproveitamento para o método get, add e remove.
     * @return o elemento.
     */
    private NoDuplo<T> getNo(int index){ // método getNo declarado privado
        NoDuplo<T> noAuxiliar = primeiroNo; // NoDuplo declara noAuxiliar se refere primeiroNo
        for (int i = 0; (i < index) && (noAuxiliar != null); i++){ //duas condições de parada
            noAuxiliar = noAuxiliar.getNoProximo(); // Quando for se true o laço estara correndo, se não ele quebra.
        }
        return noAuxiliar; // loop termina retorno noAuxiliar
    }

    /**
     * Método size
     * @return tamanho da lista.
     */
    public int size(){
        return this.tamanhoLista;
    }

    /**
     * Método toString
     * @return o elemento (strRetorno)
     * @apiNote
     */
    @Override
    public String toString() {
       String strRetorno = " "; // declara uma string vazia
       NoDuplo<T> noAuxiliar = primeiroNo; // cria um noAuxiliar
       for (int i = 0; i < size(); i++){ // for para corre esta lista
           strRetorno += "[No{conteudo= " + noAuxiliar.getConteudo() + "}]--->";
           noAuxiliar = noAuxiliar.getNoProximo(); // representa vai correr do inicio ate final
       }
       strRetorno += "null";// se tiver nula retorna nulo
       return strRetorno;
    }
}
