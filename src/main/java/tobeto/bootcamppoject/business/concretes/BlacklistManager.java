package tobeto.bootcamppoject.business.concretes;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.BlacklistService;
import tobeto.bootcamppoject.business.dto.create.blacklist.request.CreateBlacklistRequest;
import tobeto.bootcamppoject.business.dto.create.blacklist.response.CreateBlacklistResponse;
import tobeto.bootcamppoject.business.dto.get.blacklist.GetAllBlacklistResponse;
import tobeto.bootcamppoject.business.dto.get.blacklist.GetBlacklistResponse;
import tobeto.bootcamppoject.business.dto.update.blacklist.request.UpdateBlacklistRequest;
import tobeto.bootcamppoject.business.dto.update.blacklist.response.UpdateBlacklistResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.BlacklistRepository;
import tobeto.bootcamppoject.entity.Blacklist;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {

    private BlacklistRepository blacklistRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<CreateBlacklistResponse> add(
            final CreateBlacklistRequest request
    ) {

        Blacklist blacklist = mapperService.forRequest().map(request, Blacklist.class);
        blacklist.setCreatedTime(LocalDateTime.now());
        blacklistRepository.save(blacklist);

        CreateBlacklistResponse response = mapperService.forResponse()
                .map(blacklist, CreateBlacklistResponse.class);

        return new SuccessDataResult<CreateBlacklistResponse>
                (response, "Başvuran karalisteye eklendi");
    }

    @Override
    public DataResult<List<GetAllBlacklistResponse>> getAll() {

        List<Blacklist> blacklists = blacklistRepository.findAll();
        List<GetAllBlacklistResponse> blacklistResponses = blacklists.stream()
                .map(blacklist -> mapperService.forResponse()
                        .map(blacklist, GetAllBlacklistResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBlacklistResponse>>
                (blacklistResponses, "Kara listedeki herkes listelendi.");
    }

    @Override
    public DataResult<GetBlacklistResponse> getById(
            final Integer id
    ) {

        Blacklist blacklist = blacklistRepository.getById(id);
        GetBlacklistResponse response = mapperService.forResponse()
                .map(blacklist, GetBlacklistResponse.class);

        return new SuccessDataResult<GetBlacklistResponse>
                (response, "ID'e sahip başvuran blacklist içerisinden getirildi");
    }

    @Override
    public DataResult<?> delete(
            final Integer id
    ) {

        blacklistRepository.deleteById(id);
        return new SuccessDataResult("Başvuran blacklistten kaldırıldı.");
    }

    @Override
    public DataResult<UpdateBlacklistResponse> update(
            final UpdateBlacklistRequest request
    ) {

        Blacklist blacklist = blacklistRepository.getById(request.getId());
        Blacklist updatedblacklist = mapperService.forRequest().map(request, Blacklist.class);

        blacklist.setReason(updatedblacklist.getReason() != null ? updatedblacklist.getReason() : blacklist.getReason());
        blacklist.setUpdateTime(LocalDateTime.now());
        blacklistRepository.save(blacklist);

        UpdateBlacklistResponse response = mapperService.forResponse()
                .map(blacklist, UpdateBlacklistResponse.class);

        return new SuccessDataResult<UpdateBlacklistResponse>
                (response, "Blacklistte  bulunan başvuran güncellendi.");
    }

}
