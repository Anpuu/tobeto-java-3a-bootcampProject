package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.bootcampstate.request.CreateBootcampStateRequest;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.response.CreateBootcampStateResponse;
import tobeto.bootcamppoject.core.results.DataResult;

public interface BootcampStateService {
    DataResult<CreateBootcampStateResponse> create(CreateBootcampStateRequest createBootcampStateRequest);
}
