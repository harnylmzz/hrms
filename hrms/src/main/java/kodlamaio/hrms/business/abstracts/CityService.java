package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getall();
	
	Result add(City city);
	
	DataResult<List<City>> findByCityName(String cityName);
}
