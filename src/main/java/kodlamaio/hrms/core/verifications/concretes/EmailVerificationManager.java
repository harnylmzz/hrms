package kodlamaio.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.EmailVerificationService;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public Result verifyAccount(String email) {
		
		return new SuccessResult("Doğrulama kodu gönderildi, lütfen mail kutunuzu kontrol ediniz.");
	}

}
