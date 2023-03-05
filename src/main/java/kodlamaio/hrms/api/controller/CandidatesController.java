package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.dtos.requests.CreateCandidateRequest;
import kodlamaio.hrms.dtos.requests.DeleteCandidateRequest;
import kodlamaio.hrms.dtos.responses.GetAllCandidateResponses;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public	DataResult<List<GetAllCandidateResponses>> getAll() {
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result add(@RequestBody CreateCandidateRequest createCandidateRequest) {
		return this.candidateService.add(createCandidateRequest);
	}

	@DeleteMapping("/delete")
	public Result delete (DeleteCandidateRequest deleteCandidateRequest) {
		return this.candidateService.delete(deleteCandidateRequest);
	}
	
	@GetMapping("/findByFirstName")
	public DataResult<List<Candidate>> findByFirstName(@RequestParam String firstName) {
		return this.candidateService.findByFirstName(firstName);
	}
	
	@GetMapping("/findByLastName")
	public DataResult<List<Candidate>> findByLastName(@RequestParam String lastName) {
		return this.candidateService.findByLastName(lastName);
	}
	
}
