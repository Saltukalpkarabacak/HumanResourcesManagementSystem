package Project.hrms.businiess.abstracts;

import java.util.List;



import Project.hrms.core.utilities.results.DataResult;
import Project.hrms.core.utilities.results.Result;
import Project.hrms.entities.concretes.Candidate;


public interface CandidateService{
	DataResult<List<Candidate>> getAll();
	Result register(Candidate candidate);
}
