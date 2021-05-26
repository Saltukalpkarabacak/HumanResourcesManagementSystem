package Project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.hrms.businiess.abstracts.JobTitleService;
import Project.hrms.core.utilities.results.DataResult;
import Project.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobTitles")
public class JobTitleController {
	
	private JobTitleService jobTitleService;
	
	@Autowired
	public JobTitleController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobTitle>>getAll(){
		return this.jobTitleService.getAll();
	}
}
