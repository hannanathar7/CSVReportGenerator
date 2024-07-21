package com.Natwest.CSVReportGenerator.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceConfig {

    @Value("${app.csv.input.path}")
    private String inputCsvPath;

    @Value("${app.csv.reference.path}")
    private String referenceCsvPath;

    @Value("${app.csv.output.path}")
    private String outputCsvPath;

    public String getInputCsvPath() {
        return inputCsvPath;
    }

    public String getReferenceCsvPath() {
        return referenceCsvPath;
    }

    public String getOutputCsvPath() {
        return outputCsvPath;
    }
}
