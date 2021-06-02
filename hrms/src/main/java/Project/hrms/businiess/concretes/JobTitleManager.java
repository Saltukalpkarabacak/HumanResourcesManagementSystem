package Project.hrms.businiess.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.hrms.businiess.abstracts.JobTitleService;
import Project.hrms.core.utilities.results.DataResult;
import Project.hrms.core.utilities.results.ErrorResult;
import Project.hrms.core.utilities.results.Result;
import Project.hrms.core.utilities.results.SuccessDataResult;
import Project.hrms.core.utilities.results.SuccessResult;
import Project.hrms.dataAccess.abstracts.JobTitleDao;
import Project.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		return new SuccessDataResult<List<JobTitle>>
		(this.jobTitleDao.findAll(),"Data listed");	
	}

	@Override
	public Result add(JobTitle jobTitle) {
		
		List<JobTitle>jobTitles=this.jobTitleDao.findByTitle(jobTitle.getTitle());
		//email and system user accept assumed to be verified
		//mernis is assumed to be verified
		if (jobTitles.size()>0) {
				return new ErrorResult("User already defined");
		}
		
		
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("JobTitle added");
	}

}
