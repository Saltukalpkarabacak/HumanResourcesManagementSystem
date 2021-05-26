package Project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
