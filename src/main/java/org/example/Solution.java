package org.example;

//Java
import java.util.*;


public class Solution {


    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);


        String n_Longitud = sc.nextLine();
        String[] parts = n_Longitud.split(" ");

        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);

        String elements = sc.nextLine();
        String[] partsElements = elements.split(" ");
        int[] A = new int[K];
        for (int i = 0; i < K; i++) {
            A[i] = Integer.parseInt(partsElements[i]);
        }

        //Call function
        List<Integer> result = new Solution().problem_solve(N,A);

        // Imprimir el resultado
        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }

    //Function which solves the problem
    public List<Integer> problem_solve(int N, int[] A){
        Arrays.sort(A);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, new ArrayList<>(Collections.singletonList(1))));

        // Set para evitar ciclos
        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // devolver el camino
            if (current.value == N) {
                return current.path;
            }

            // Generar los próximos estados
            for (int multiplier : A) {
                long nextValue = (long) current.value * multiplier;
                if (nextValue > N) continue; // Ignorar valores mayores a N
                if (!visited.contains((int) nextValue)) {
                    visited.add((int) nextValue);

                    // Crear el nuevo camino y añadirlo a la cola
                    List<Integer> newPath = new ArrayList<>(current.path);
                    newPath.add(multiplier);
                    queue.offer(new Node((int) nextValue, newPath));
                }
            }
        }

        // Si no encuentra una solución, devolver lista vacía
        return new ArrayList<>();
    }

    static class Node {
        int value; // raiz
        List<Integer> path; // camino para llegar a la raiz

        Node(int value, List<Integer> path) {
            this.value = value;
            this.path = path;
        }
    }
}
