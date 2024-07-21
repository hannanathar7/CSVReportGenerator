package com.Natwest.CSVReportGenerator.Service;

import com.Natwest.CSVReportGenerator.Model.InputRecord;
import com.Natwest.CSVReportGenerator.Model.OutputRecord;
import com.Natwest.CSVReportGenerator.Model.ReferenceRecord;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class ReportGenerationService {

    private static final Logger logger = LoggerFactory.getLogger(ReportGenerationService.class);

    @Autowired
    private FileProcessingService fileProcessingService;

    @Autowired
    private TransformationService transformationService;

    public void generateReport() {
        String inputFilePath = "src/main/resources/data/input.csv";
        String referenceFilePath = "src/main/resources/data/reference.csv";
        String outputFilePath = "src/main/resources/data/output.csv";

        List<InputRecord> inputRecords;
        List<ReferenceRecord> referenceRecords;

        try {
            inputRecords = fileProcessingService.readInputCsv(inputFilePath);
            referenceRecords = fileProcessingService.readReferenceCsv(referenceFilePath);
        } catch (IOException | CsvException e) {
            logger.error("Error reading input or reference CSV file", e);
            return;
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
            // Write header
            writer.writeNext(new String[]{"outfield1", "outfield2", "outfield3", "outfield4", "outfield5"});

            for (InputRecord input : inputRecords) {
                OutputRecord output = transformationService.transform(input, referenceRecords);
                if (output != null) {
                    writer.writeNext(new String[]{
                            output.getOutfield1(),
                            output.getOutfield2(),
                            output.getOutfield3(),
                            String.valueOf(output.getOutfield4()),
                            String.valueOf(output.getOutfield5())
                    });
                }
            }
            logger.info("Report generation completed successfully");
        } catch (IOException e) {
            logger.error("Error writing output CSV file", e);
        }
    }
}