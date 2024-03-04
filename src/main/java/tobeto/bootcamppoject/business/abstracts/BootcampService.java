package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.bootcamp.request.BootcampCreateRequest;
import tobeto.bootcamppoject.business.dto.create.bootcamp.response.BootcampCreateResponse;
import tobeto.bootcamppoject.core.results.DataResult;

public interface BootcampService {
    DataResult<BootcampCreateResponse> createBootcamp(BootcampCreateRequest bootcampCreateRequest);
}
