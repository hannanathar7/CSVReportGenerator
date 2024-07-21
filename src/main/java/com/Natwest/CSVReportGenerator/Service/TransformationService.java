package com.Natwest.CSVReportGenerator.Service;


import com.Natwest.CSVReportGenerator.Model.InputRecord;
import com.Natwest.CSVReportGenerator.Model.OutputRecord;
import com.Natwest.CSVReportGenerator.Model.ReferenceRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransformationService {

    public OutputRecord transform(InputRecord inputRecord, List<ReferenceRecord> referenceRecords) {
        Optional<ReferenceRecord> referenceRecordOpt = referenceRecords.stream()
                .filter(ref -> ref.getRefkey1().equals(inputRecord.getRefkey1()) && ref.getRefkey2().equals(inputRecord.getRefkey2()))
                .findFirst();

        if (referenceRecordOpt.isPresent()) {
            ReferenceRecord referenceRecord = referenceRecordOpt.get();
            String outfield1 = inputRecord.getField1() + inputRecord.getField2();
            String outfield2 = referenceRecord.getRefdata1();
            String outfield3 = referenceRecord.getRefdata2() + referenceRecord.getRefdata3();
            double maxField = Math.max(inputRecord.getField5(), referenceRecord.getRefdata4());
            double outfield4 = Double.parseDouble(inputRecord.getField3()) * maxField;
            double outfield5 = maxField;

            return new OutputRecord(outfield1, outfield2, outfield3, outfield4, outfield5);
        } else {
            // Handle case when no matching reference record is found
            return null;
        }
    }
}