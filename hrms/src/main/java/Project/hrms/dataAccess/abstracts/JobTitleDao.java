package Project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{

}
