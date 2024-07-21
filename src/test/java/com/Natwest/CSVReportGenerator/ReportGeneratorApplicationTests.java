package com.Natwest.CSVReportGenerator;

import com.Natwest.CSVReportGenerator.Controller.ReportGenerationController;
import com.Natwest.CSVReportGenerator.Service.ReportGenerationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ReportGeneratorApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        // Test if the Spring application context loads successfully
    }

    @Test
    void testReportGenerationServiceBean() {
        // Test if the ReportGenerationService bean is loaded into the application context
        ReportGenerationService reportGenerationService = applicationContext.getBean(ReportGenerationService.class);
        assertNotNull(reportGenerationService, "ReportGenerationService bean should be loaded");
    }

    @Test
    void testReportGenerationControllerBean() {
        // Test if the ReportGenerationController bean is loaded into the application context
        ReportGenerationController reportGenerationController = applicationContext.getBean(ReportGenerationController.class);
        assertNotNull(reportGenerationController, "ReportGenerationController bean should be loaded");
    }
}