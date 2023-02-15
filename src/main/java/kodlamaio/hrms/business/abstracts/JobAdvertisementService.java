package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getall();
	
	Result add(JobAdvertisement advertisement);
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> findByJobDescription(String jobAdvertisement);
}
