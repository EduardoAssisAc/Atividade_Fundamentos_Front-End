import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ArraysDinamicos {
    public static void main(String[] args) {
        // Criando um Array dinâmico em Java
        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(5);
        numeros.add(2);
        numeros.add(9);
        numeros.add(7);
        numeros.add(1);

        //Imprimindo através do laço for
        for (int item : numeros){
            System.out.println(item);
        }

        System.out.println("------------");

        //Ordenando o Array através do método sort
        Collections.sort(numeros);
        for (int item : numeros){
            System.out.println(item);
        }
        System.out.println("");

        // Busca do número 9 através do método binarySearch
        int posicao = Collections.binarySearch(numeros,9);

        System.out.println("A posição do número 9 é: " + (posicao+1) + "\n");

        // Cria a nova lista maiores e adiciona os três maiores numeros da lista numeros
        List<Integer> maiores = new ArrayList<Integer>(numeros.subList(2, 5));
        System.out.println(maiores);
        System.out.println("");

        //Faz uma comparação que verifica se o Array maiores é igual numeros
        Boolean comparacao = maiores.equals(numeros);
        
        if (comparacao) {
            System.out.println("É igual");
        }else{
        System.out.println("Não é igual");
        }

        //Método para inverter o Array
        Collections.reverse(numeros);
        
        for (Integer item : numeros) {
            System.out.println(item);
        }
    }
}
