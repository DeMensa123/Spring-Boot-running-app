package sk.fsa.project.fsaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.fsa.project.fsaproject.model.Beh;

@Repository
public interface BehRepository extends JpaRepository<Beh, Long> {

}
