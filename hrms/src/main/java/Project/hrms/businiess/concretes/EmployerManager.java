package Project.hrms.businiess.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Project.hrms.businiess.abstracts.EmployerService;
import Project.hrms.core.utilities.results.DataResult;
import Project.hrms.core.utilities.results.ErrorResult;
import Project.hrms.core.utilities.results.Result;
import Project.hrms.core.utilities.results.SuccessDataResult;
import Project.hrms.core.utilities.results.SuccessResult;
import Project.hrms.dataAccess.abstracts.EmployerDao;
import Project.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"Data Listed");
	}

	@Override
	public Result add(Employer employer) {
		
		List<Employer>employers=this.employerDao.findByEmail(employer.getEmail());
		//email and system user accept assumed to be verified
		//mernis is assumed to be verified
		if (employers.size()>0) {
				return new ErrorResult("User already defined");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("User added");
		
	}

}
