package com.assignment.assignment2;

public class FileProcessor {
    public static int GetAverage(int[] values){
        if(values.length == 0)
            return -1;

        int output = 0;
        for(int i = 0; i < values.length;i++){
            output += values[i];
        }
        output /= values.length;

        return output;
    }

    public static int GetMaximum(int[] values){
        if(values.length == 0)
            return -1;

        int temp = -99999;
        for(int i = 0; i < values.length;i++){
            if(values[i] > temp)
                temp = values[i];
        }

        return temp;
    }

    public static int GetMinimum(int[] values){
        if(values.length == 0)
            return -1;

        int temp = 999999;
        for(int i = 0; i < values.length;i++){
            if(values[i] < temp)
                temp = values[i];
        }

        return temp;
    }
}
