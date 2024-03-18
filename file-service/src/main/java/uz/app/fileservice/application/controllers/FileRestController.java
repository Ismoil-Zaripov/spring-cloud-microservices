package uz.app.fileservice.application.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.app.fileservice.domain.models.FileResponse;
import uz.app.fileservice.domain.usecases.FileUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/files")
public class FileRestController {

    private final FileUseCase fileUseCase;

    @PostMapping("/save")
    public ResponseEntity<FileResponse> saveFile(MultipartFile multipartFile){
        FileResponse fileResponse = fileUseCase.saveFile(multipartFile);
        return ResponseEntity.ok(fileResponse);
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<byte[]> openFile(@PathVariable String fileId) {
        byte[] openedFile = fileUseCase.openFile(fileId);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(openedFile);
    }

}
