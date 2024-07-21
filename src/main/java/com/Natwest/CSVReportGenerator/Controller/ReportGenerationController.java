package com.Natwest.CSVReportGenerator.Controller;



import com.Natwest.CSVReportGenerator.Service.ReportGenerationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReportGenerationController {

    private static final Logger logger = LoggerFactory.getLogger(ReportGenerationController.class);

    @Autowired
    private ReportGenerationService reportGenerationService;

    @GetMapping("/generateReport")
    public String generateReport() {
        logger.info("Report generation triggered via REST API");
        try {
            reportGenerationService.generateReport();
            logger.info("Report generation completed successfully");
            return "Report generation completed successfully";
        } catch (Exception e) {
            logger.error("Error occurred during report generation", e);
            return "Report generation failed: " + e.getMessage();
        }
    }


}
