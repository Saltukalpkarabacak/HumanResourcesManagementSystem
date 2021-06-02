package Project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	List<Candidate> findByEmail(String email);
}
