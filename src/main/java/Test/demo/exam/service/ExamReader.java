package Test.demo.exam.service;

import Test.demo.exam.dto.ExamCSVRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExamReader {
    List<ExamCSVRequest> read(MultipartFile file);
}
