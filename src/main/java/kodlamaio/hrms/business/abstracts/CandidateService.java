package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.dtos.requests.CreateCandidateRequest;
import kodlamaio.hrms.dtos.requests.DeleteCandidateRequest;
import kodlamaio.hrms.dtos.responses.GetAllCandidateResponses;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<List<GetAllCandidateResponses>> getAll();
	
	Result add(CreateCandidateRequest createCandidateRequest);

	Result delete(DeleteCandidateRequest deleteCandidateRequest);
	
	DataResult<List<Candidate>> findByFirstName(String firstName);
	
	DataResult<List<Candidate>> findByLastName(String lastName);
}
