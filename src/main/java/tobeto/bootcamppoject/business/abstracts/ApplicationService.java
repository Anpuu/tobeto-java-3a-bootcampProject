package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.application.request.ApplicationCreateRequest;
import tobeto.bootcamppoject.business.dto.create.application.response.ApplicationCreateResponse;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;

public interface ApplicationService {
    SuccessDataResult<ApplicationCreateResponse> create(ApplicationCreateRequest applicationCreateRequest);
}
