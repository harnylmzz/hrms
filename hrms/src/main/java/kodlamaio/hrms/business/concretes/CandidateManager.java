package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "İş arayanlar listelendi!");
				
				
	}

	@Override
	public Result add(Candidate candidate) {
		
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan eklendi!");
	}

	@Override
	public DataResult<List<Candidate>> findByFirstName(String firstName) {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByFirstName(firstName), "Data listelendi!");
	}

	@Override
	public DataResult<List<Candidate>> findByLastName(String lastName) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByLastName(lastName), "İş arayanlar listelendi!");
	}

}
