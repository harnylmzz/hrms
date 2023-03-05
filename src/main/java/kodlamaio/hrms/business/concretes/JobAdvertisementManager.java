package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.mappers.ModelMapperService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.JobAdvertisementDao;
import kodlamaio.hrms.dtos.requests.CreateJobAdvertisementRequest;
import kodlamaio.hrms.dtos.requests.DeleteJobAdvertisementRequest;
import kodlamaio.hrms.dtos.requests.UpdateJobAdvertisementRequest;
import kodlamaio.hrms.dtos.responses.GetAllJobAdvertisementResponses;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllJobAdvertisementResponses>> getall() {

		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll();

		List<GetAllJobAdvertisementResponses> getAllJobAdvertisementResponses = jobAdvertisements.stream()
				.map(jobAdvertisement -> this.modelMapperService.forResponse()
						.map(jobAdvertisement, GetAllJobAdvertisementResponses.class))
				.collect(Collectors.toList());

		return new DataResult<List<GetAllJobAdvertisementResponses>>(getAllJobAdvertisementResponses, true,
				"Data getirildi.");
	}

	@Override
	public Result add(CreateJobAdvertisementRequest createJobAdvertisementRequest) {
		JobAdvertisement jobAdvertisement = this.modelMapperService.forRequest().map(createJobAdvertisementRequest,
				JobAdvertisement.class);
		this.jobAdvertisementDao.save(jobAdvertisement);

		return new SuccessResult("İş ilanı eklendi!");
	}

	@Override
	public Result delete(DeleteJobAdvertisementRequest deleteJobAdvertisementRequest) {
		JobAdvertisement jobAdvertisement = this.modelMapperService.forRequest().map(deleteJobAdvertisementRequest, JobAdvertisement.class);
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("İş ilanı sistemden kaldırıldı!");
	}

	@Override
	public Result update(UpdateJobAdvertisementRequest updateJobAdvertisementRequest) {
		JobAdvertisement jobAdvertisement = this.modelMapperService.forRequest().map(updateJobAdvertisementRequest, JobAdvertisement.class);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı güncellendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue(),
				"İş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByJobDescription(String jobDescription) {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByJobDescription(jobDescription), "İş tanımları listelendi.");
	}

}
