package com.Natwest.CSVReportGenerator.Config;

import com.Natwest.CSVReportGenerator.Service.ReportGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Autowired
    private ReportGenerationService reportGenerationService;

    // Schedule the report generation to run every day at midnight
    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleReportGeneration() {
        reportGenerationService.generateReport();
    }
}