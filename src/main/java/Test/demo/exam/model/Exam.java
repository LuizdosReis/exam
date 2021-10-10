package Test.demo.exam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"code"})
@Table(name = "exams")
public class Exam {

    @Id
    private String code;

    @NotBlank
    private String source;

    @NotBlank
    private String codeListCode;

    @NotBlank
    private String displayValue;

    private String longDescription;

    @NotNull
    private LocalDate fromDate;

    private LocalDate toDate;

    private int sortingPriority;
}
