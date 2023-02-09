package kodlamaio.hrms.core.verifications.concretes;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.AccountConfirmationService;

public class AccountConfirmationManager implements AccountConfirmationService {

	@Override
	public Result accountConfirmation(String email) {
		
		return new SuccessResult("Şirket hesabınız başarılı bir şekilde oluşturuldu!");
	}

}
