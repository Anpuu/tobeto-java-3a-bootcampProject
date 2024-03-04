package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.bootcamp.request.BootcampCreateRequest;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.request.BootcampStateCreateRequest;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.response.BootcampStateCreateResponse;
import tobeto.bootcamppoject.core.results.DataResult;

public interface BootcampStateService {
    DataResult<BootcampStateCreateResponse> create(BootcampStateCreateRequest bootcampStateCreateRequest);
}
