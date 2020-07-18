/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rutas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Sebastian
 */
public class Rutas {
    
    public static int Dios(int grafo[][],int n){
        Stack<Integer> pila = new Stack<Integer>();

        int cont2 = 0;
        pila.add(1);
        
        while(!pila.isEmpty()){      
            int var = pila.pop();          
            for(int i = 1; i < grafo.length ; i++){
               if(i == n){
                   if(grafo[var][i]==1){
                       cont2++;
                   }
               }
               if(grafo[var][i] == 1){
                   pila.add(i);
               }  
            }  
        }
        return cont2;
    }
  
    public static void main(String[] args) {
       
        Scanner myobj = new Scanner(System.in);
        int cont = 0 ;
        int n = myobj.nextInt();
        int M = myobj.nextInt();
        int grafo[][] = new int[n+1][n+1];
        
        for(int i = 1; i < M+1; i++){
            int a = myobj.nextInt();
            int b = myobj.nextInt();
            grafo[a][b] = 1;
  
        }
         cont = Dios(grafo,n);
        System.out.println(cont);
        
    }
    
    
}
