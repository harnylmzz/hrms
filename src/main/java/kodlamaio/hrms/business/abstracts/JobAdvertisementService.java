package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.dtos.requests.CreateJobAdvertisementRequest;
import kodlamaio.hrms.dtos.requests.DeleteJobAdvertisementRequest;
import kodlamaio.hrms.dtos.responses.GetAllJobAdvertisementResponses;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<GetAllJobAdvertisementResponses>> getall();
	
	Result add(CreateJobAdvertisementRequest createJobAdvertisementRequest);

	Result delete(DeleteJobAdvertisementRequest deleteJobAdvertisementRequest);

	Result update();
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> findByJobDescription(String jobDescription);
}
