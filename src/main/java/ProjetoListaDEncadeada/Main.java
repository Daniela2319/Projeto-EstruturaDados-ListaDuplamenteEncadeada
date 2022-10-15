package ProjetoListaDEncadeada;

/**
 * Classe principal do projeto Lista Duplamente Encadeada
 * @author aluna Daniela Velter
 * @author Instrutor João Dutra
 */
public class Main {
    public static void main(String[] args) {

       ListaDuplamenteEncadeada<String> minhaListaED = new ListaDuplamenteEncadeada<>();

       minhaListaED.add("Dani");
       minhaListaED.add("João");
       minhaListaED.add("Frank");
       minhaListaED.add("Val");
       minhaListaED.add("Valdemar");
       minhaListaED.add("Junior");
       minhaListaED.add("Paula");

        System.out.println(minhaListaED);

        minhaListaED.remove(5);

        System.out.println(minhaListaED.get(5));

       minhaListaED.add(2,"Jane");

        System.out.println(minhaListaED);

        System.out.println(minhaListaED.get(2));


    }
}
