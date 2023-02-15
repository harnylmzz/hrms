package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;

import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) throws NumberFormatException, RemoteException{
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		return kpsPublicSoapProxy.TCKimlikNoDogrula(
				Long.parseLong(candidate.getIdentityNumber()), 
				candidate.getFirstName(), 
				candidate.getLastName(), 
				candidate.getBirthDay());
	}

}
