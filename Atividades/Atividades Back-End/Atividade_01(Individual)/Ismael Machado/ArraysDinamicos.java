import java.util.*;

public class ArraysDinamicos {
    
    public static void main(String[] args) {
    
        List<Integer> numeros = new ArrayList<Integer>();
        
        numeros.add(5);
        numeros.add(2);
        numeros.add(9);
        numeros.add(7);
        numeros.add(1);
        
        System.out.println("Lista números:");
        for (Integer item : numeros) {
            System.out.print(" " + item);
        }
        System.out.println("");
        Collections.sort(numeros); 

        System.out.println("Lista números ordenada:");
        for (Integer item : numeros) {
            System.out.print(" " + item);
        }

        System.out.println("");
        int buscaResultado = Collections.binarySearch(numeros, 9);
        System.out.println("Resultado da busca na Lista números:");
        System.out.println(" " + buscaResultado);

        List<Integer> maiores = new ArrayList<Integer>();
        maiores = numeros.subList(2, 5);

        System.out.println("Lista maiores:");
        for (Integer item : maiores) {
            System.out.print(" " + item);
        }

        System.out.println("");
        System.out.println("Resultado da comparação entre numeros e maiores:");
        System.out.println(numeros.equals(maiores));
        
        Collections.reverse(numeros);
        System.out.println("Lista números invertida:");
        for (Integer item : numeros) {
            System.out.print(" " + item);
        }
    }

}
