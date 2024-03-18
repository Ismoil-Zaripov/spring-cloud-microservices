package uz.app.fileservice.domain.models;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record FileResponse(
        String uuid,
        String filename,
        String path,
        String url,
        Long size
) implements Serializable { }
