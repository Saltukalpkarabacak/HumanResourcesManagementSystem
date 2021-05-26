package Project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.hrms.businiess.abstracts.CandidateService;
import Project.hrms.core.utilities.results.DataResult;
import Project.hrms.core.utilities.results.Result;
import Project.hrms.entities.concretes.Candidate;


@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
	
	private CandidateService candidateService;
	
	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>>getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/register")
	public Result register(@RequestBody Candidate candidate) {
		return this.candidateService.register(candidate);
	}
}
