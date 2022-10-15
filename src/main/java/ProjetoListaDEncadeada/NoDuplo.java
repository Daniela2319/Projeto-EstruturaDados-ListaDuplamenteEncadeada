package ProjetoListaDEncadeada;


/**
 * Representa classe NoDuplo tipo generico
 * @param <T> NoDuplo
 */
public class NoDuplo<T> {

    //Atribudos
    private T conteudo;
    private NoDuplo<T> noProximo;
    private NoDuplo<T> noPrevio;


    //Construtor
    public NoDuplo( T conteudo){ // No duplo do tipo generico T
        this.conteudo = conteudo; // this.conteudo do objeto,rebece conteudo igual conteudo.
    }


    // Getter e Setter
    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(NoDuplo<T> noProximo) {
        this.noProximo = noProximo;
    }

    public NoDuplo<T> getNoPrevio() {
        return noPrevio;
    }

    public void setNoPrevio(NoDuplo<T> noPrevio) {
        this.noPrevio = noPrevio;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
