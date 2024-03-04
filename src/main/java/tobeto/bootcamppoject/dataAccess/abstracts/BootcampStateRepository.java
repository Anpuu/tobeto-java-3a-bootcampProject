package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.request.BootcampStateCreateRequest;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.response.BootcampStateCreateResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import tobeto.bootcamppoject.entity.BootcampState;

public interface BootcampStateRepository extends JpaRepository<BootcampState,Integer> {
}
