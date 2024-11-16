package org.example;


//Java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LordOfRing {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        sc.nextLine();
        String elements = sc.nextLine();
        String[] partsElements = elements.split(" ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(partsElements[i]);
        }

        //Call function
        List<Integer> result = new LordOfRing().problem_solve(A);
            for (int num : result) {
                System.out.print(num + " ");
            }

    }

    public List<Integer> problem_solve(int [] potential){
        Stack<Integer> stack = new Stack<>();


        for(int p: potential){

          while(!stack.isEmpty() && differentSign(stack.peek(),p)){
              int top = stack.pop();
              if(Math.abs(top) > Math.abs(p)){
                  stack.push(top);
                  p=0;
              }
              if(Math.abs(top) == Math.abs(p)){ //ambos se eliminan
                  p=0;
              }
          }
            if (p != 0) {
                stack.push(p); // Agrega al luchador al ring si no fue eliminado
            }


        }

        return new ArrayList<>(stack);
    }

    public static Boolean differentSign(int a, int b){
        if(a < 0 && b < 0) return false;
        if(a >= 0 && b >= 0)return false;
        return true;
    }
}
