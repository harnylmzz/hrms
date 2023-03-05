package kodlamaio.hrms.dtos.requests;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCandidateRequest {
    
    private String firstName;

    private String lastName;

    private String identityNumber;

    private Date birthDay;

    private String email;
    
    private String password;

}
