package Test.demo.exam.controller;

import Test.demo.exam.dto.ExamResponse;
import Test.demo.exam.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping(path = ExamController.BASE_URL)
@AllArgsConstructor
public class ExamController {

    public static final String BASE_URL = "/exams";
    private final ExamService examsService;

    @PostMapping("/upload")
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) {
        this.examsService.upload(file);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<ExamResponse>> getAll() {
        return ResponseEntity.ok(this.examsService.getAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<ExamResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(this.examsService.getByCode(code));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteAll() {
        this.examsService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
