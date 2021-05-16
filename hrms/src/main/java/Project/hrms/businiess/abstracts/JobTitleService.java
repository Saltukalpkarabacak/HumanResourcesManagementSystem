package Project.hrms.businiess.abstracts;

import java.util.List;

import Project.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
}
