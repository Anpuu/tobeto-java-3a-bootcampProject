package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.bootcampstate.request.CreateBootcampStateRequest;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.response.CreateBootcampStateResponse;
import tobeto.bootcamppoject.business.dto.get.bootcampState.GetAllBootcampStateResponse;
import tobeto.bootcamppoject.business.dto.get.bootcampState.GetBootcampStateResponse;
import tobeto.bootcamppoject.business.dto.update.bootcampState.request.UpdateBootcampStateRequest;
import tobeto.bootcamppoject.business.dto.update.bootcampState.response.UpdateBootcampStateResponse;
import tobeto.bootcamppoject.core.utilities.results.DataResult;

import java.util.List;

public interface BootcampStateService {

    DataResult<CreateBootcampStateResponse> create(CreateBootcampStateRequest createBootcampStateRequest);

    DataResult<List<GetAllBootcampStateResponse>> getAll();

    DataResult<GetBootcampStateResponse> getById(Integer id);

    DataResult<?> delete(int id);

    DataResult<UpdateBootcampStateResponse> updateBootcampState(UpdateBootcampStateRequest request,Integer id);

}
