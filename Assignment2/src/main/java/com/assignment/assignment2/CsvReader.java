package com.assignment.assignment2;

import java.io.*;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;

import org.apache.commons.csv.*;

class CsvReader {
    public void readFromFile(String filename) {
        try {
            Reader in = new FileReader(HelloApplication.class.getResource(filename).getPath());

            String airline = "airline";
            String availSeatKmPerWeek = "avail_seat_km_per_week";
            String incidents8599 = "incidents_85_99";
            String fatalIncidents8599 = "fatal_accidents_85_99";
            String fatalities8589 = "fatalities_85_99";
            String incidents0014 = "incidents_00_14";
            String fatalIncidents0014 = "fatal_accidents_00_14";
            String fatalities0014 = "fatalities_00_14";

            CSVFormat.Builder builder = CSVFormat.Builder.create(CSVFormat.DEFAULT)
                    .setHeader(
                            airline,
                            availSeatKmPerWeek,
                            incidents8599,
                            fatalIncidents8599,
                            fatalities8589,
                            incidents0014,
                            fatalIncidents0014,
                            fatalities0014);

            Iterable<CSVRecord> records = builder.build().parse(in);

            in.close();

            ArrayList<ArrayList<String>> rowData = new ArrayList<ArrayList<String>>();

            for (CSVRecord record : records) {
                var row = new ArrayList<String>();

                // Check if this record is the first one
                if (record.equals(records.iterator().next())) {
                    row.add(record.get(airline));
                    row.add(record.get(availSeatKmPerWeek));
                    row.add(record.get(incidents8599));
                    row.add(record.get(fatalIncidents8599));
                    row.add(record.get(fatalities8589));
                    row.add(record.get(incidents0014));
                    row.add(record.get(fatalIncidents0014));
                    row.add(record.get(fatalities0014));
                    row.add("incidents_85_14");
                    continue;
                }

                row.add(record.get(airline));
                row.add(record.get(availSeatKmPerWeek));
                row.add(record.get(incidents8599));
                int inc8589 = Integer.parseInt(row.get(row.size() - 1));

                row.add(record.get(fatalIncidents8599));
                row.add(record.get(fatalities8589));
                row.add(record.get(incidents0014));
                int inc0014 = Integer.parseInt(row.get(row.size() - 1));

                row.add(record.get(fatalIncidents0014));
                row.add(record.get(fatalities0014));

                row.add(String.format("%d", inc8589 + inc0014));

                rowData.add(row);
            }

            int numRows = rowData.size();
            int numColumns = rowData.get(0).size();

            for (int j = 0; j < numColumns; j++) {
                var list = new ArrayList<String>();
                // Convert the row data into column data
                for (int i = 1; i < numRows; i++) {
                    list.add(rowData.get(i).get(j));
                }
                DataBase.AppendColumn(rowData.get(0).get(j), list);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}