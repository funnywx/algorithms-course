package com.xw.dynamicprogramming;

import java.lang.reflect.ParameterizedType;

/**
 * 矩阵链乘
 */
public class MatrixChain {


    private static int[] p = {30,35,15,5,10,20,25};
    /**
     * 递归式
     * m[i,j] = 0, i==j
     *        = min(m[i,k] + m[k+1,j] + p(i-1)*pk*pj) , i<j
     */

    //构造代价矩阵
    public static void MATRIX_CHAIN_ORDER(int[] p,int[][] m,int[][] s){

        int n = p.length-1;           //矩阵个数
        for(int i = 0 ; i < n ;i++){
            m[i][i] = 0;
        }
        //按对角线填入(0,1)-(1,2)-(2,3)-(3,4)这样依次对相邻的矩阵计算(即最小子问题)
        for (int l = 1; l < n ; l++){   //对角线
            for (int i = 0; i < n-l ; i++){   //行
                int j = i+l;           //列
                m[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j ; k++){  //计算每个分割点
                    int q = m[i][k] + m[k+1][j] + p[i]*p[k+1]*p[j+1];
                    if(q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }

                }
                Knapsack01.printa(m);
            }
        }
    }

    public static void PRINT_OPTIMAL_PARENS(int[][] m,int[][] s,int i,int j){
        if(i == j){
            System.out.print("A"+(i+1));
        }else {
            System.out.print("(");
            PRINT_OPTIMAL_PARENS(m,s,i,s[i][j]);
            PRINT_OPTIMAL_PARENS(m,s,s[i][j]+1,j);
            System.out.print(")");
        }

    }

    public static void main(String[] args) {
        int[][] m = new int[p.length-1][p.length-1];
        int[][] s = new int[p.length-1][p.length-1];
        MATRIX_CHAIN_ORDER(p,m,s);
        Knapsack01.printa(m);
        Knapsack01.printa(s);
        PRINT_OPTIMAL_PARENS(m,s,0,5);
    }

}
