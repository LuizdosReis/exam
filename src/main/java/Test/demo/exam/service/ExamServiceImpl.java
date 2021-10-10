package Test.demo.exam.service;

import Test.demo.exam.dto.ExamCSVRequest;
import Test.demo.exam.dto.ExamResponse;
import Test.demo.exam.mapper.ExamMapper;
import Test.demo.exam.model.Exam;
import Test.demo.exam.repository.ExamRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ExamServiceImpl implements ExamService {

    private final ExamReader examsReader;
    private final ExamMapper examMapper;
    private final ExamRepository examRepository;

    @Override
    public void upload(MultipartFile file) {
        List<ExamCSVRequest> examCSVRequestList = this.examsReader.read(file);
        List<Exam> examList = this.examMapper.map(examCSVRequestList);
        this.examRepository.saveAll(examList);
    }

    @Override
    public List<ExamResponse> getAll() {
        return this.examMapper.mapToResponseList(this.examRepository.findAll());
    }

    @Override
    public ExamResponse getByCode(String code) {
        Exam exam = this.examRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("No exam found with ID - " + code));
        return this.examMapper.mapToResponse(exam);
    }

    @Override
    public void deleteAll() {
        this.examRepository.deleteAll();
    }
}
