package sk.fsa.project.fsaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.fsa.project.fsaproject.model.Stanovisko;

@Repository
public interface StanoviskoRepository extends JpaRepository<Stanovisko, Long> {
}
