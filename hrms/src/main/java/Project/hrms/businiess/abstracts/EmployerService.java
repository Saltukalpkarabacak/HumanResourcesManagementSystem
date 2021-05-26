package Project.hrms.businiess.abstracts;

import java.util.List;

import Project.hrms.core.utilities.results.DataResult;
import Project.hrms.core.utilities.results.Result;
import Project.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
