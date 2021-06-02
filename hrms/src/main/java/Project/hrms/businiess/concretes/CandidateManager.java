package Project.hrms.businiess.concretes;

import java.util.List;


import org.springframework.stereotype.Service;

import Project.hrms.businiess.abstracts.CandidateService;
import Project.hrms.core.utilities.results.DataResult;
import Project.hrms.core.utilities.results.ErrorResult;
import Project.hrms.core.utilities.results.Result;
import Project.hrms.core.utilities.results.SuccessDataResult;
import Project.hrms.core.utilities.results.SuccessResult;
import Project.hrms.dataAccess.abstracts.CandidateDao;
import Project.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"Data listed");	
	}

	@Override
	public Result register(Candidate candidate) {
		
		List<Candidate>candidates=this.candidateDao.findByEmail(candidate.getEmail());
		//email is assumed to be verified
		//mernis is assumed to be verified
		if (candidates.size()>0) {
				return new ErrorResult("User already defined");
		}
		this.candidateDao.save(candidate);
		return new SuccessResult("User added");
	}

}
