package Test.demo.exam.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamCSVRequest {

    @CsvBindByPosition(position = 0)
    private String source;

    @CsvBindByPosition(position = 1)
    private String codeListCode;

    @CsvBindByPosition(position = 2)
    private String code;

    @CsvBindByPosition(position = 3)
    private String displayValue;

    @CsvBindByPosition(position = 4)
    private String longDescription;

    @CsvBindByPosition(position = 5)
    private String fromDate;

    @CsvBindByPosition(position = 6)
    private String toDate;

    @CsvBindByPosition(position = 7)
    private int sortingPriority;
}
