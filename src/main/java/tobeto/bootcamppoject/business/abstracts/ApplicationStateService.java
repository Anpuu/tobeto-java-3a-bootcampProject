package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.applicationstate.request.ApplicationStateCreateRequest;
import tobeto.bootcamppoject.business.dto.create.applicationstate.response.ApplicationStateCreateResponse;
import tobeto.bootcamppoject.core.results.DataResult;

public interface ApplicationStateService {

    DataResult<ApplicationStateCreateResponse> create(ApplicationStateCreateRequest applicationStateCreateRequest);
}
