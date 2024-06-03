import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraysDinamicos {

    public static void main(String[] args) {
        // Criando e inicializando o array dinâmico de inteiros 'numeros'
        List<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(2);
        numeros.add(9);
        numeros.add(7);
        numeros.add(1);

        // Imprimindo os elementos do array 'numeros' utilizando um loop for
        System.out.println("Elementos do array 'numeros' (usando for):");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.print(numeros.get(i) + " ");
        }
        System.out.println();

        // Imprimindo os elementos do array 'numeros' utilizando um loop for-each
        System.out.println("Elementos do array 'numeros' (usando for-each):");
        for (Integer numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // Ordenando o array 'numeros' em ordem crescente e imprimindo os elementos
        Collections.sort(numeros);
        System.out.println("Elementos do array 'numeros' (ordenados):");
        for (Integer numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // Buscando o número 9 no array 'numeros' e imprimindo o resultado
        int indice = Collections.binarySearch(numeros, 9);
        System.out.println("Índice do número 9 no array 'numeros': " + indice);

        // Criando um novo array dinâmico de inteiros 'maiores'
        List<Integer> maiores = new ArrayList<>();

        // Copiando os três maiores números do array 'numeros' para o array 'maiores'
        maiores = numeros.subList(numeros.size() - 3, numeros.size());

        // Imprimindo os elementos do array 'maiores'
        System.out.println("Elementos do array 'maiores':");
        for (Integer numero : maiores) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // Comparando os arrays 'numeros' e 'maiores' e imprimindo o resultado
        boolean saoIguais = numeros.equals(maiores);
        System.out.println("Os arrays 'numeros' e 'maiores' são iguais? " + saoIguais);

        // Imprimindo os elementos do array 'numeros' em ordem decrescente
        Collections.sort(numeros, Collections.reverseOrder());
        System.out.println("Elementos do array 'numeros' (ordem decrescente):");
        for (Integer numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}
