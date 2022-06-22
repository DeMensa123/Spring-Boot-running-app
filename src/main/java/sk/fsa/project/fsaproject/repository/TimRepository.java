package sk.fsa.project.fsaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.fsa.project.fsaproject.model.Tim;

import java.util.List;


@Repository
public interface TimRepository extends JpaRepository<Tim, Long> {

    List<Tim> findByNazov(String nazov);
}
