package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.bootcamp.request.CreateBootcampRequest;
import tobeto.bootcamppoject.business.dto.create.bootcamp.response.CreateBootcampResponse;
import tobeto.bootcamppoject.business.dto.get.application.GetAllApplicationResponse;
import tobeto.bootcamppoject.business.dto.get.application.GetByIdApplicationResponse;
import tobeto.bootcamppoject.business.dto.get.bootcamp.GetAllBootcampResponse;
import tobeto.bootcamppoject.business.dto.get.bootcamp.GetByIdBootcampResponse;
import tobeto.bootcamppoject.business.dto.update.application.request.UpdateApplicationRequest;
import tobeto.bootcamppoject.business.dto.update.application.response.UpdateApplicationResponse;
import tobeto.bootcamppoject.business.dto.update.bootcamp.request.UpdateBootcampRequest;
import tobeto.bootcamppoject.business.dto.update.bootcamp.response.UpdateBootcampResponse;
import tobeto.bootcamppoject.core.results.DataResult;

import java.util.List;

public interface BootcampService {
    DataResult<CreateBootcampResponse> createBootcamp(CreateBootcampRequest createBootcampRequest);

    DataResult<GetByIdBootcampResponse> getById(Integer applicationId);

    DataResult<List<GetAllBootcampResponse>> getAll();

    DataResult<UpdateBootcampResponse> updateApplication(UpdateBootcampRequest updateBootcampRequest, Integer applicationId);

    DataResult<?> deletedByIdBootcamp(Integer id);
}
