package com.Natwest.CSVReportGenerator.Util;

import com.Natwest.CSVReportGenerator.Model.InputRecord;
import com.Natwest.CSVReportGenerator.Model.ReferenceRecord;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class CsvUtilTest {

    @Mock
    private CsvUtil csvUtil;

    public CsvUtilTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testReadInputCsv() throws IOException, CsvException {
        // Arrange
        CsvUtil csvUtil = new CsvUtil();
        List<InputRecord> expectedRecords = new ArrayList<>();
        expectedRecords.add(new InputRecord("a", "b", "c", "d", 10.0, "key1", "key2"));

        // Act
        List<InputRecord> records = csvUtil.readInputCsv("src/test/resources/input.csv");

        // Assert
        assertEquals(expectedRecords.size(), records.size());
        assertEquals(expectedRecords.get(0).getField1(), records.get(0).getField1());
    }

    @Test
    void testReadReferenceCsv() throws IOException, CsvException {
        // Arrange
        CsvUtil csvUtil = new CsvUtil();
        List<ReferenceRecord> expectedRecords = new ArrayList<>();
        expectedRecords.add(new ReferenceRecord("key1", "data1", "key2", "data2", "data3", 20.0));

        // Act
        List<ReferenceRecord> records = csvUtil.readReferenceCsv("src/test/resources/reference.csv");

        // Assert
        assertEquals(expectedRecords.size(), records.size());
        assertEquals(expectedRecords.get(0).getRefkey1(), records.get(0).getRefkey1());
    }

    @Test
    void testWriteOutputCsv() throws IOException {
        // Arrange
        CsvUtil csvUtil = new CsvUtil();
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"ab", "data1", "data2data3", "30.0", "20.0"});

        // Act
        csvUtil.writeOutputCsv("src/test/resources/output.csv", data);

        // Assert
        // Check if the file was created and contains the expected data (implement your own verification)
    }

}

