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
/*
    @Override
    public ApplicantCreatRequest updateApplicant(
          final ApplicantCreatRequest applicantCreatRequest,
          final Integer applicantID
    ) {
        ApplicantCreatRequest applicantToBeUpdate = applicantRepository.findById(applicantID)
                .orElseThrow(() -> new RuntimeException("Id'e ait bir başvuran bulunamadı.!"));

        modelMapperService.forResponse().map(applicantCreatRequest,applicantToBeUpdate);

       return applicantRepository.save(applicantToBeUpdate);
    }

    @Override
    public ApplicantCreatRequest getById(Integer applicantID) {

        return applicantRepository.findById(applicantID)
                .orElseThrow(() -> new RuntimeException("Id'e ait bir başvuran bulunamadı."));
    }

    @Override
    public void getAll() {

        applicantRepository.findAll();

    }

    @Override
    public void deleteApplicantByID(
           final ApplicantCreatRequest applicantCreatRequest,
           final Integer applicantID
    ) {
        applicantRepository.findById(applicantID)
                .orElseThrow(() -> new RuntimeException("Id'e sahip bir başvuran bulunamadı..."));
        applicantRepository.deleteById(applicantID);
    }

    @Override
    public void deleteAll() {
        applicantRepository.deleteAll();
    }

*/
}
