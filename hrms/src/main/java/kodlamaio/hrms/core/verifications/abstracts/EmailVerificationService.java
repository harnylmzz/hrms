package kodlamaio.hrms.core.verifications.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;

public interface EmailVerificationService {

	Result verifyAccount (String email);
}
