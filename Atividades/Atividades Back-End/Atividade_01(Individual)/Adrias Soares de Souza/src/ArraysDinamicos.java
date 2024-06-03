// Adrias Soares de Souza

// Questões da Atividade:

/*
X - Crie um array dinâmico de inteiros com o nome numeros, e valores 5, 2, 9, 7 e 1.

X - Imprima os elementos do array numeros utilizando um loop forou for-each.

X - Utilize o método sort() da classe java.util.Collections para ordenar o array numeros em ordem crescente e imprima os elementos do array numeros.x

X - Utilize o método binarySearch() da classe java.util.Collections para buscar o número 9 no array numeros e imprima na tela o resultado da busca.

X - Crie um novo array dinâmico de inteiros chamado maiores.

X - Utilize o método subList() para copiar os três maiores números do array numeros para o array maiores, e imprima os elementos do array maiores.

X - Utilize o método equals() para comparar os arrays numeros e maiores e imprima na tela o resultado da comparação.

X - Imprima na tela os elementos do array numeros em ordem decrescente.

Não há apenas uma única forma de fazer isso. Pesquise sobre as soluções possíveis e escolha uma.
*/

// Codigo principal:
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ArraysDinamicos {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<Integer>();

        
        
        // Outra forma de adicionar os numeros ao ArrayD
        // Collection.addAll(numeros, 5, 2, 9, 7, 1);

        // Adicionando numeros ao ArrayD
        numeros.add(5);
        numeros.add(2);
        numeros.add(9);
        numeros.add(7);
        numeros.add(1);

        // Imprimindo os numeros do ArrayD
        System.out.println("\nnumeros no Array Dinamico 'numeros': ");
        for (int n : numeros){
            System.out.print(n + " ");
        }
        System.out.println("\n");
        
        // Ordenando os elementos de "numeros" utilizando Collections
        Collections.sort(numeros);

        // Imprimindo os numeros do ArrayD Ordenado
        System.out.println("numeros no Array Dinamico Ordenado: ");
        for (int n : numeros){
            System.out.print(n + " ");
        }
        System.out.println("\n");

        // Buscando o numeros 9 no ArrayD com o método binarySearch
        int key = 10;
        int busca = Collections.binarySearch(numeros, key);

        // Imprimindo o resultado da busca de binary search, brinquei um pouco usando a estrutura condicional if
        if (busca == -6){
            System.out.println("O numero " + key + " não foi encontrado no array, tente outro, ou adicione o elemento.");
        } else {
            System.out.println("O numero " + key + " tem o indice " + busca + " no Array");
        }
        System.out.println();

        // Criando um novo ArrayD chamdo maiores 
        List<Integer> maiores = new ArrayList<Integer>();

        // Adicionando os maiores elementos do Array "numeros" ao Array "maiores"
        maiores.addAll(numeros.subList(numeros.size()-3, numeros.size()));

        // Imprimindo os numeros no Array Maiores
        System.out.println("os 3 maiores numeros do Array Numeros são: ");
        for (Integer n : maiores){
            System.out.print(n + " ");
        }
        System.out.println("\n");

        // aplicando o metodo equals para comparar os Arrays numeros e maiores e imprimindo o resultado
        boolean iguais = numeros.equals(maiores);
        System.out.print("Os Arrays 'numeros' e 'maiores' são: ");
        if (iguais){
            System.out.println("Iguais");
        } else {
            System.out.println("Diferentes");
        }
        System.out.println("");

        // Revertendo os elementos de "numeros" utilizando Collections
        Collections.reverse(numeros);
        System.out.println("elementos do Array Numeros em ordem decrescente");
        for (Integer n : numeros) {
            System.out.print(n + " ");
        }


    }

    // Exemplos Professor

    // // Arrays
    // int[] numeros = new int[5];
    // int[] numeros2 = {10, 20, 30, 40, 50}; // inicializado
    // for (int i = 0; i < 5; i++){
    //     System.out.println("Indice [" + (i+1) + "]:" + numeros[i]);
    // }

    // Array Dinamico
    // List<Integer> n_dinamico = new ArrayList<Integer>();
    // n_dinamico.add(25);

    // for(int i = 1; i < 11; i++){
    //     n_dinamico.add((int)Math.pow((double) i, 3.0));
    // }

    // n_dinamico.remove(0);
    // n_dinamico.remove(n_dinamico.size()-1);
    // n_dinamico.remove(n_dinamico.indexOf(27));

    // for (int item : n_dinamico){
    //     System.out.println("Item" + "[" + n_dinamico.indexOf(item) + "]");
    // }

}
