package Test.demo.exam.service;

import Test.demo.exam.dto.ExamCSVRequest;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class ExamReaderImpl implements ExamReader {

    public List<ExamCSVRequest> read(MultipartFile file)  {
        try {
            Reader reader = new InputStreamReader(file.getInputStream());
            return new CsvToBeanBuilder(reader)
                    .withType(ExamCSVRequest.class)
                    .withSkipLines(1)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new RuntimeException("Impossible read file");
        }
    }


}
