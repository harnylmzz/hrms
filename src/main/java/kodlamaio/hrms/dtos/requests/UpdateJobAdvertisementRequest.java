package kodlamaio.hrms.dtos.requests;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateJobAdvertisementRequest {

    private int id;

    private String jobDescription;

    private double maxSalary;

    private double minSalary;

    private int openPosition;

    private Date applicationDeadline;

    private Date releaseDate;

    private boolean isActive;

}
