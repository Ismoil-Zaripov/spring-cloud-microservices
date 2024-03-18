package uz.app.fileservice.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.fileservice.domain.models.FileResponse;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "files")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String filename;
    private String path;
    private String url;
    private Long size;

    public FileResponse mapToResponse() {
        return FileResponse.builder()
                .uuid(uuid)
                .filename(filename)
                .path(path)
                .url(url)
                .size(size)
                .build();
    }
}