/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Sebastian
 */
public class Reference {

    public static int[] FindPath(int cost[][], int u, int v) {
        Stack<Integer> pila = new Stack<Integer>();
        int[][] info = new int[cost.length][4];
        
        pila.add(u);

        info[u][0] = 0;
        info[u][1] = 1;
        info[u][2] = -6;
        info[u][3] = 0;

        while (!pila.isEmpty()) {
            int index = pila.pop();

            for (int i = 0; i < cost.length; i++) {
                if (info[i][1] == 1 && i!= u ) {
                    if (info[index][0] + cost[index][i] < info[i][0]) {
                        info[i][0] = info[index][0] + cost[index][i];
                        info[i][2] = index;
                        info[i][3] = info[index][3] + 1;
                        pila.add(i);
                    } 
                    else if (info[index][0] + cost[index][i] == info[i][0]) {
                        if (info[i][3] > info[index][3]) {
                            info[i][2] = index;
                            info[i][3] = info[index][3] + 1;
                        }
                    }
                }

                if (cost[index][i] != 0 && cost[index][i] != 9999 && info[i][1] != 1) {
                    if (i != v) {
                        pila.add(i);
                    }
                    info[i][0] = info[index][0] + cost[index][i];
                    info[i][1] = 1;
                    info[i][2] = index;
                    info[i][3] = info[index][3] + 1;
                
                }
                
            }
        }
        int[] ruta = new int[info[v][3]+1];
        ruta[0] = v;
        int z = 1;
        while(v != u){
            int a = info[v][2];
            ruta[z] = a;
            z++;
            v = a;
        }
        ruta[ruta.length - 1] = u;


        return ruta;
    }

    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);
        int n = myobj.nextInt();
        int[] valor;

        int[][] costos = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = myobj.nextInt();
                costos[i][j] = a;
            }
        }

        int u = myobj.nextInt();
        int v = myobj.nextInt();

        valor = FindPath(costos, u, v);
        int h = 1;
        for(int i = valor.length - 1; i >= 0 ; i--){
            if(h % 2 == 0 && valor[i]!= v){
                System.out.print(valor[i]);
                System.out.println(" ");
                h++;  
            }
            System.out.print(valor[i] + " ");
           
            h++;
        }

    }

}
