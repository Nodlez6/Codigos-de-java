/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conquista;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Sebastian
 */
public class Conquista {
    public static boolean real(boolean[] revisados){
        for(int i = 0; i < revisados.length ; i++){
            if(revisados[i] == false){
                return true;
            }
        }
      return false;  
    }
    public static void Dios(ArrayList<ArrayList<Integer>> aux, int var, boolean[] revisados, Stack<Integer> aparte){
        revisados[var] = true;
        for(int i = 0; i < aux.get(var).size(); i++){
            
            if(revisados[aux.get(var).get(i)] == false){
                Dios(aux,aux.get(var).get(i),revisados, aparte);
            } 
        }
        aparte.add(var);
        
    }
    public static void ahorasixd(ArrayList<ArrayList<Integer>> aux2, boolean[] revisados2,int var){
        
        revisados2[var] = true;
        for(int i = 0; i < aux2.get(var).size() ; i++){
            
            if(revisados2[aux2.get(var).get(i)] == false){
                ahorasixd(aux2,revisados2,aux2.get(var).get(i));  
            }
        }
    }

    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> aux2 = new ArrayList<ArrayList<Integer>>();
        int contador = 0;
        
        int contador1;
        
        Stack<Integer> aparte = new Stack();
        int nodos = myobj.nextInt();
        boolean[] revisados = new boolean[nodos];
        boolean[] revisados2 = new boolean[nodos];
        int aristas = myobj.nextInt();
         int[][] agregar = new int[aristas][2];
        for (int i = 0; i < aristas; i++) {
            agregar[i][0] = myobj.nextInt();
            agregar[i][1] = myobj.nextInt();
        }
        for(int i = 0; i < nodos; i++ ){
            aux.add(new ArrayList<Integer>());
            aux2.add(new ArrayList<Integer>());
        }
        for(int j = 0; j < agregar.length ;j++){
            aux.get(agregar[j][0]).add(agregar[j][1]);
            aux2.get(agregar[j][1]).add(agregar[j][0]);
        }

        int i = 0;
        while(real(revisados)){
            Dios(aux,i ,revisados,aparte);
            i++;
        }
        
         
        while(!aparte.isEmpty()){
            int var = aparte.pop();
            if(revisados2[var] == false){
                ahorasixd(aux2,revisados2,var);
                contador++;
            }  
        }
        System.out.println(contador);
 
    }
    
}
