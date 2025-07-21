package br.com.flixy.repository;

import br.com.flixy.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
