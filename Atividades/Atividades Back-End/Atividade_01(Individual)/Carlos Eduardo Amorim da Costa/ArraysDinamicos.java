import java.util.ArrayList;
import java.util.Collections;

    public class ArraysDinamicos {
        public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(2);
        numeros.add(9);
        numeros.add(7);
        numeros.add(1);

        System.out.println("Elementos do array numeros:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        Collections.sort(numeros);
        // System.out.println(numeros);
        System.out.println("\nArray numeros ordenado em ordem crescente:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        // int indice_teste = numeros.indexOf(9);
        // System.out.println("\n" + indice_teste);
        int indice = Collections.binarySearch(numeros, 9);
        
        if (indice >= 0){
            System.out.println("\nBusca pelo número 9: Encontrado na posição " + indice);
        }
        else{
            System.out.println("\nBusca pelo número 9: Não encontrado");
        }

        ArrayList<Integer> maiores = new ArrayList<>();

        maiores.addAll(numeros.subList(numeros.size() - 3, numeros.size()));

        System.out.println("Três maiores números do array:");
        for (int numero : maiores) {
            System.out.print(numero + " ");
        }

        boolean saoIguais = numeros.equals(maiores);
        System.out.println("Os arrays numeros e maiores são iguais? " + (saoIguais ? "Sim" : "Não"));

        System.out.println("Array numeros em ordem decrescente:");
        for (int i = numeros.size() - 1; i >= 0; i--) {
            System.out.print(numeros.get(i) + " ");
        }
    }
}