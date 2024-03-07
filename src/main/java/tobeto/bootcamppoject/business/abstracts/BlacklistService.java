package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.blacklist.request.CreateBlacklistRequest;
import tobeto.bootcamppoject.business.dto.create.blacklist.response.CreateBlacklistResponse;
import tobeto.bootcamppoject.business.dto.get.blacklist.GetAllBlacklistResponse;
import tobeto.bootcamppoject.business.dto.get.blacklist.GetBlacklistResponse;
import tobeto.bootcamppoject.business.dto.update.blacklist.request.UpdateBlacklistRequest;
import tobeto.bootcamppoject.business.dto.update.blacklist.response.UpdateBlacklistResponse;
import tobeto.bootcamppoject.core.results.DataResult;

import java.util.List;

public interface BlacklistService {
    DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest request);

    DataResult<List<GetAllBlacklistResponse>> getAll();

    DataResult<GetBlacklistResponse> getById(Integer id);

    DataResult<?> delete(Integer id);

    DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest request);

}
