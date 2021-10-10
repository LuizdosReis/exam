package Test.demo.exam.mapper;

import Test.demo.exam.dto.ExamCSVRequest;
import Test.demo.exam.dto.ExamResponse;
import Test.demo.exam.model.Exam;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ExamMapper {

    public abstract List<Exam> map(List<ExamCSVRequest> examRequestList);

    public abstract List<ExamResponse> mapToResponseList(List<Exam> examList);

    @AfterMapping
    void fillToDateIfIsNotEmpty(@MappingTarget Exam exam, ExamCSVRequest examRequest) {
        if(examRequest.getToDate() != null && !examRequest.getToDate().isBlank()) {
            exam.setFromDate(LocalDate.parse(examRequest.getFromDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
    }

    @Mapping(source = "fromDate", target = "fromDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "toDate", ignore = true)
    public abstract Exam toModel(ExamCSVRequest examRequest);

    public abstract ExamResponse mapToResponse(Exam exam);
}
