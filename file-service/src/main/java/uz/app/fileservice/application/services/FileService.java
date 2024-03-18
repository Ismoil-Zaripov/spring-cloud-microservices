package uz.app.fileservice.application.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.app.fileservice.domain.entities.FileEntity;
import uz.app.fileservice.domain.models.FileResponse;
import uz.app.fileservice.domain.usecases.FileUseCase;
import uz.app.fileservice.infrastructure.jpa.repository.FileJpaRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import static java.time.LocalDateTime.now;

@Service
@Transactional
@RequiredArgsConstructor
public class FileService implements FileUseCase {

    private final FileJpaRepository fileJpaRepository;

    @Override
    public FileResponse saveFile(MultipartFile multipartFile) {

        String path = "file-service/files/%s".formatted(getYearMonthDay());

        File directory = new File(path);
        if (!directory.exists()) directory.mkdir();

        path = String.format("%s/%s", path, multipartFile.getOriginalFilename());

        try (OutputStream outputStream = new FileOutputStream(path)) {

            String fileUrl = "http://localhost:8080/api/v1/files/open/%s"
                    .formatted(multipartFile.getOriginalFilename());

            outputStream.write(multipartFile.getBytes());

            FileEntity fileEntity = FileEntity.builder()
                    .filename(multipartFile.getOriginalFilename())
                    .path(path)
                    .url(fileUrl)
                    .size(multipartFile.getSize())
                    .build();

            fileJpaRepository.save(fileEntity);
            return fileEntity.mapToResponse();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String getYearMonthDay() {
        return String.format("%s/%s/%s", now().getYear(), now().getMonthValue(), now().getDayOfMonth());
    }

    @Override
    public byte[] openFile(String fileId) {
        FileEntity fileEntity = fileJpaRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found..."));

        try {
            return Files.readAllBytes(new File(fileEntity.getPath()).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
