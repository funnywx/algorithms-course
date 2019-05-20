package com.xw.dynamicprogramming;

/**
 * 01背包问题
 * 问题描述：小偷背包容量为W，商品i的价值Vi，重量Wi，如何带走价值最高的物品集
 * 商品只有拿与不拿
 */
public class knapsack01 {

    private static int[] W = {0,2,3,4,5};
    private static int[] V = {0,3,4,5,6};

    /**
     * 递归式i为物品 j为当前背包剩余容量
     * V(i,j) = V(i-1,j) , j < Wi
     *          Max( V(i-1,j) , V(i-1,j-Wi) + Vi) ) j>=Wi
     */
    public static int[][] sovle(int[] W,int[] V,int bagW){
        int n = W.length;
        int[][] a = new int[n][bagW+1];
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j <= bagW ; j++){
                if(W[i] > j) a[i][j] = a[i-1][j];
                if(W[i] <= j) a[i][j] = a[i-1][j-W[i]] + V[i];
                printa(a);
            }
        }
        return a;
    }

    private static void printa(int[][] a){
        for(int i = 0; i < a.length ; i++){
            for(int j = 0;j < a[0].length ;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        int[][] a = sovle(W,V,8);
    }






}
