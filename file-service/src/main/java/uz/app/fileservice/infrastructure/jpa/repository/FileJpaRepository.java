package uz.app.fileservice.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.app.fileservice.domain.entities.FileEntity;

@Repository
public interface FileJpaRepository extends JpaRepository<FileEntity, String> { }