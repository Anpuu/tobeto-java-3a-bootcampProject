package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.ApplicantService;
import tobeto.bootcamppoject.business.dto.create.applicant.request.ApplicantCreatRequest;
import tobeto.bootcamppoject.business.dto.create.applicant.response.ApplicantCreateResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetByIdResponse;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperServiceImpl;
import tobeto.bootcamppoject.dataAccess.abstracts.ApplicantRepository;
import tobeto.bootcamppoject.entity.Applicant;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ApplicantGetByIdResponse getById(
           final Integer applicantID
    ) {
        Applicant gettingApplicantById = applicantRepository.findById(applicantID)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir başvuran bulunamadı.!"));

        ApplicantGetByIdResponse response = modelMapperService.forResponse()
                .map(gettingApplicantById,ApplicantGetByIdResponse.class);

        return response;
    }

    @Override
    public List<ApplicantGetAllResponse> getAll() {

        List<Applicant> applicants = applicantRepository.findAll();

        List<ApplicantGetAllResponse> applicantResponses =
                applicants.stream().map(applicant -> modelMapperService
                        .forResponse().map(applicant, ApplicantGetAllResponse.class))
                        .collect(Collectors.toList());

        return applicantResponses;
    }
}
