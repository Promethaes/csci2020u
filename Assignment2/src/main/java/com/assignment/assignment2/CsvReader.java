package com.assignment.assignment2;

import java.io.*;
import org.apache.commons.csv.*;

class CsvReader {
    public void readFromFile(String filename) {
        try {
            Reader in = new FileReader("data.csv");

            String firstNameHeader = "First Name";
            String lastNameHeader  = "Last Name";
            String sidHeader       = "SID";
            String gradeHeader     = "Grade";

            CSVFormat.Builder builder = 
                CSVFormat.Builder.create(CSVFormat.DEFAULT)
                    .setHeader(
                        firstNameHeader,
                        lastNameHeader,
                        sidHeader,
                        gradeHeader
                    );

            Iterable<CSVRecord> records =
                builder.build().parse(in);
            
            for (CSVRecord record : records) {
                String lastName  = record.get(lastNameHeader);
                String firstName = record.get(firstNameHeader);
                String grade     = record.get(gradeHeader);
                
                System.out.printf("%s %s (%s)\n", firstName, lastName, grade);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}