package com.Natwest.CSVReportGenerator.Config;

import com.Natwest.CSVReportGenerator.Service.ReportGenerationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class SchedulerConfigTest {

    @InjectMocks
    private SchedulerConfig schedulerConfig;

    @Mock
    private ReportGenerationService reportGenerationService;

    public SchedulerConfigTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testScheduleReportGeneration() {
        // Act
        schedulerConfig.scheduleReportGeneration();

        // Assert
        verify(reportGenerationService, times(1)).generateReport();
    }
}
