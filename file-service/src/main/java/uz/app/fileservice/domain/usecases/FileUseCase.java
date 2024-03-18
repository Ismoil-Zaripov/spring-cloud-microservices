package uz.app.fileservice.domain.usecases;

import org.springframework.web.multipart.MultipartFile;
import uz.app.fileservice.domain.models.FileResponse;

public interface FileUseCase {
    FileResponse saveFile(MultipartFile multipartFile);
    byte[] openFile(String fileId);
}
