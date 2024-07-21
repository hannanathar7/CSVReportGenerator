package com.Natwest.CSVReportGenerator.Service;


import com.Natwest.CSVReportGenerator.Model.InputRecord;
import com.Natwest.CSVReportGenerator.Model.ReferenceRecord;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileProcessingService {

    public List<InputRecord> readInputCsv(String filePath) throws IOException, CsvException {
        List<InputRecord> records = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> lines = reader.readAll();
            for (String[] line : lines) {
                records.add(new InputRecord(line[0], line[1], line[2], line[3], Double.parseDouble(line[4]), line[5], line[6]));
            }
        }
        return records;
    }

    public List<ReferenceRecord> readReferenceCsv(String filePath) throws IOException, CsvException {
        List<ReferenceRecord> records = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> lines = reader.readAll();
            for (String[] line : lines) {
                records.add(new ReferenceRecord(line[0], line[1], line[2], line[3], line[4], Double.parseDouble(line[5])));
            }
        }
        return records;
    }
}