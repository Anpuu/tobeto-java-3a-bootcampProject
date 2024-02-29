package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.ApplicantService;
import tobeto.bootcamppoject.business.dto.Applicant.request.ApplicantCreatRequest;
import tobeto.bootcamppoject.business.dto.Applicant.response.ApplicantCreateResponse;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperServiceImpl;
import tobeto.bootcamppoject.dataAccess.abstracts.ApplicantRepository;
import tobeto.bootcamppoject.entity.Applicant;

@Service
@RequiredArgsConstructor
public class ApplicantManager implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    private final ModelMapperServiceImpl modelMapperService;

    @Override
    public ApplicantCreateResponse create(
           final ApplicantCreatRequest applicantCreatRequest
    ) {

        Applicant createdApplicant = modelMapperService.forRequest()
                .map(applicantCreatRequest, Applicant.class);

        applicantRepository.save(createdApplicant);

        ApplicantCreateResponse response = modelMapperService.forResponse()
                .map(createdApplicant,ApplicantCreateResponse.class);

        return response;
    }

}
