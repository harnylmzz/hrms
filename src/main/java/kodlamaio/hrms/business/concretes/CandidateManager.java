package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.mappers.ModelMapperService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.CandidateDao;
import kodlamaio.hrms.dtos.requests.CreateCandidateRequest;
import kodlamaio.hrms.dtos.requests.DeleteCandidateRequest;
import kodlamaio.hrms.dtos.responses.GetAllCandidateResponses;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllCandidateResponses>> getAll() {

		List<Candidate> candidates = candidateDao.findAll();

		List<GetAllCandidateResponses> getAllCandidateResponses = candidates.stream()
				.map(candidate -> this.modelMapperService.forResponse()
						.map(candidate, GetAllCandidateResponses.class))
				.collect(Collectors.toList());

		return new DataResult<List<GetAllCandidateResponses>>(getAllCandidateResponses, true,
				"Çalışan bilgileri getirildi!");

	}

	@Override
	public Result add(CreateCandidateRequest createCandidateRequest) {
		Candidate candidate = this.modelMapperService.forRequest()
				.map(createCandidateRequest, Candidate.class);

		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan sisteme eklendi!");
	}

	@Override
	public Result delete(DeleteCandidateRequest deleteCandidateRequest) {

		Candidate candidate = this.modelMapperService.forRequest()
				.map(deleteCandidateRequest, Candidate.class);
		return new SuccessResult("İş arayan sistemden silindi!");
	}

	@Override
	public DataResult<List<Candidate>> findByFirstName(String firstName) {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByFirstName(firstName), "Data listelendi!");
	}

	@Override
	public DataResult<List<Candidate>> findByLastName(String lastName) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByLastName(lastName),
				"İş arayanlar listelendi!");
	}

}
