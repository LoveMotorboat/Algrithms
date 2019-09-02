package com.liyang.maxrecsize;

import java.util.Stack;

//求一个只由0和1构成的矩阵中的最大子矩阵的面积，该子矩阵只由1构成
//1、以每一行做切割，统计以当前行为底的情况下，每个位置往上的1的数量
//2、对于每一次切割，都利用更新后的数组height来求以当前行为底的最大矩阵的面积，更新最大矩阵的面积值
public class MaxRecSize {
    public static int maxRecFromBottom(int[] height){
        //求以当前height为底的最大矩阵的面积
        if (height == null || height.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty()? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty()? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static int maxRecSize(int[][] map){
        if (map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){
                height[j] = map[i][j] ==0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }
}
