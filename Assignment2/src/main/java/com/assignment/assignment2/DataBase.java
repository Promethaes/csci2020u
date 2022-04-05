package com.assignment.assignment2;

import java.util.ArrayList;

public class DataBase {
    //first row is column names
    public static ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    public static void AppendColumn(String name, ArrayList<String> inData){
        data.get(0).add(name);
        for (int i = 1; i < inData.size(); i++) {
            data.get(i).set(data.get(i).size() - 1,inData.get(i - 1));
        }
    }

}
