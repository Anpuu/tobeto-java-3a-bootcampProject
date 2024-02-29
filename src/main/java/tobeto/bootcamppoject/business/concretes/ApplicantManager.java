package tobeto.bootcamppoject.business.concretes;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.ApplicantService;
import tobeto.bootcamppoject.business.constants.ApplicantMessage;
import tobeto.bootcamppoject.business.dto.create.applicant.request.ApplicantCreatRequest;
import tobeto.bootcamppoject.business.dto.create.applicant.response.ApplicantCreateResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetByIdResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperServiceImpl;
import tobeto.bootcamppoject.dataAccess.abstracts.ApplicantRepository;
import tobeto.bootcamppoject.entity.Applicant;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicantManager implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    private final ModelMapperServiceImpl modelMapperService;

    @Override
    public DataResult<ApplicantCreateResponse> create(
            final ApplicantCreatRequest applicantCreatRequest
    ) {
        Applicant createdApplicant = modelMapperService.forRequest()
                .map(applicantCreatRequest, Applicant.class);

        createdApplicant.setCreatedTime(LocalDateTime.now());

        applicantRepository.save(createdApplicant);

        ApplicantCreateResponse response = modelMapperService.forResponse()
                .map(createdApplicant, ApplicantCreateResponse.class);

        return new
                SuccessDataResult<ApplicantCreateResponse>
                (response, ApplicantMessage.ApplicantAdded);

    }

    @Override
    public DataResult<ApplicantGetByIdResponse> getById(
            final Integer applicantID
    ) {
        Applicant gettingApplicantById = applicantRepository.findById(applicantID)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir başvuran bulunamadı.!"));

        ApplicantGetByIdResponse response = modelMapperService.forResponse()
                .map(gettingApplicantById, ApplicantGetByIdResponse.class);

        return new SuccessDataResult<ApplicantGetByIdResponse>
                (response,ApplicantMessage.ApplicantBroughtById);
    }

    @Override
    public DataResult<List<ApplicantGetAllResponse>> getAll() {

        List<Applicant> applicants = applicantRepository.findAll();

        List<ApplicantGetAllResponse> applicantResponses =
                applicants.stream().map(applicant -> modelMapperService
                                .forResponse().map(applicant, ApplicantGetAllResponse.class))
                        .collect(Collectors.toList());

        return new SuccessDataResult<List<ApplicantGetAllResponse>>
                (applicantResponses,ApplicantMessage.ApplicantListed);
    }
}
