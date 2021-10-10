package Test.demo.exam.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExamResponse {

    private String source;
    private String codeListCode;
    private String code;
    private String displayValue;
    private String longDescription;
    private String fromDate;
    private String toDate;
    private int sortingPriority;
}
