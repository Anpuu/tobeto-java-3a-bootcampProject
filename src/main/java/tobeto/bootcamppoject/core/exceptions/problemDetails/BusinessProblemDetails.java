package tobeto.bootcamppoject.core.exceptions.problemDetails;

import org.springframework.http.HttpStatus;

public class BusinessProblemDetails extends ProblemDetails {

    public BusinessProblemDetails(){
        setTitle("Business Rule Violation");
        setType("http://google.com/exceptions/business");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
