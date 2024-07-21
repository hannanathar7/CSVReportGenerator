package com.Natwest.CSVReportGenerator.Repository;


import com.Natwest.CSVReportGenerator.Model.OutputRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<OutputRecord, Long> {
    // Define custom query methods if necessary
}
