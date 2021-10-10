package Test.demo.exam.service;

import Test.demo.exam.dto.ExamResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExamService {
    void upload(MultipartFile file);
    List<ExamResponse> getAll();
    ExamResponse getByCode(String code);
    void deleteAll();
}
