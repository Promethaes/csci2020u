package com.assignment.assignment2;

import java.util.ArrayList;

public class FileProcessor {
    public static Integer GetAverage(ArrayList<Integer> values){
        if(values.size() == 0)
            return -1;

        Integer output = 0;
        for(int i = 0; i < values.size();i++){
            output += values.get(i);
        }
        output /= values.size();

        return output;
    }

    public static Integer GetMaximum(ArrayList<Integer> values){
        if(values.size() == 0)
            return -1;

        Integer temp = -99999;
        for(int i = 0; i < values.size();i++){
            if(values.get(i) > temp)
                temp = values.get(i);
        }

        return temp;
    }

    public static int GetMinimum(ArrayList<Integer> values){
        if(values.size() == 0)
            return -1;

        int temp = 999999;
        for(int i = 0; i < values.size();i++){
            if(values.get(i) < temp)
                temp = values.get(i);
        }

        return temp;
    }
}
