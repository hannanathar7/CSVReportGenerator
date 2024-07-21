package com.Natwest.CSVReportGenerator.Util;


import com.Natwest.CSVReportGenerator.Model.InputRecord;
import com.Natwest.CSVReportGenerator.Model.ReferenceRecord;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvUtil {

    public List<InputRecord> readInputCsv(String filePath) throws IOException, CsvException {
        List<InputRecord> records = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                InputRecord record = new InputRecord(line[0], line[1], line[2], line[3],
                        Double.parseDouble(line[4]), line[5], line[6]);
                records.add(record);
            }
        }
        return records;
    }

    public List<ReferenceRecord> readReferenceCsv(String filePath) throws IOException, CsvException {
        List<ReferenceRecord> records = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                ReferenceRecord record = new ReferenceRecord(line[0], line[1], line[2],
                        line[3], line[4], Double.parseDouble(line[5]));
                records.add(record);
            }
        }
        return records;
    }

    public void writeOutputCsv(String filePath, List<String[]> data) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(data);
        }
    }
}
