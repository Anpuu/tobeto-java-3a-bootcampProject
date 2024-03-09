package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.ApplicantService;
import tobeto.bootcamppoject.business.constants.ApplicantMessage;
import tobeto.bootcamppoject.business.dto.create.applicant.request.CreatApplicantRequest;
import tobeto.bootcamppoject.business.dto.create.applicant.response.CreateApplicantResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.GetAllApplicantResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.GetByIdApplicantResponse;
import tobeto.bootcamppoject.business.dto.update.applicant.request.UpdateApplicantRequest;
import tobeto.bootcamppoject.business.dto.update.applicant.response.UpdateApplicantResponse;
import tobeto.bootcamppoject.business.rules.UserBusinessRules;
import tobeto.bootcamppoject.core.utilities.results.DataResult;
import tobeto.bootcamppoject.core.utilities.results.success.SuccessDataResult;
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

    private final UserBusinessRules userBusinessRules;

    @Override
    public DataResult<CreateApplicantResponse> create(
            final CreatApplicantRequest creatApplicantRequest
    ) {

        userBusinessRules.checkIfEmailExists(creatApplicantRequest.getEmail());

        Applicant createdApplicant = modelMapperService.forRequest()
                .map(creatApplicantRequest, Applicant.class);

        createdApplicant.setCreatedTime(LocalDateTime.now());

        applicantRepository.save(createdApplicant);

        CreateApplicantResponse response = modelMapperService.forResponse()
                .map(createdApplicant, CreateApplicantResponse.class);

        return new
                SuccessDataResult<CreateApplicantResponse>
                (response, ApplicantMessage.ApplicantAdded);

    }

    @Override
    public DataResult<GetByIdApplicantResponse> getById(
            final Integer applicantID
    ) {
        Applicant gettingApplicantById = applicantRepository.findById(applicantID)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir başvuran bulunamadı.!"));

        GetByIdApplicantResponse response = modelMapperService.forResponse()
                .map(gettingApplicantById, GetByIdApplicantResponse.class);

        return new SuccessDataResult<GetByIdApplicantResponse>
                (response, ApplicantMessage.ApplicantBroughtById);
    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAll() {

        List<Applicant> applicants = applicantRepository.findAll();

        List<GetAllApplicantResponse> applicantResponses =
                applicants.stream().map(applicant -> modelMapperService
                                .forResponse().map(applicant, GetAllApplicantResponse.class))
                        .collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicantResponse>>
                (applicantResponses, ApplicantMessage.ApplicantListed);
    }

    @Override
    public DataResult<UpdateApplicantResponse> updateByIDApplicant(
            final UpdateApplicantRequest updateApplicantRequest,
            final Integer id
    ) {
        Applicant foundApplicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip başvuran bulunamadı."));

        Applicant applicantToUpdate = modelMapperService
                .forRequest().map(updateApplicantRequest, Applicant.class);

        foundApplicant.setId(id);
        foundApplicant.setUpdateTime(LocalDateTime.now());
        foundApplicant.setFirstName(applicantToUpdate.getFirstName() != null ? applicantToUpdate.getFirstName() : foundApplicant.getFirstName());
        foundApplicant.setLastName(applicantToUpdate.getLastName() != null ? applicantToUpdate.getLastName() : foundApplicant.getLastName());
        foundApplicant.setUserName(applicantToUpdate.getUserName() != null ? applicantToUpdate.getUserName() : foundApplicant.getUserName());
        foundApplicant.setAbout(applicantToUpdate.getAbout() != null ? applicantToUpdate.getAbout() : foundApplicant.getAbout());
        foundApplicant.setDateOfBirth(applicantToUpdate.getDateOfBirth() != null ? applicantToUpdate.getDateOfBirth() : foundApplicant.getDateOfBirth());
        foundApplicant.setNationalIdentity(applicantToUpdate.getNationalIdentity() != null ? applicantToUpdate.getNationalIdentity() : foundApplicant.getNationalIdentity());

        applicantRepository.save(foundApplicant);

        UpdateApplicantResponse response = modelMapperService.forResponse().map(foundApplicant, UpdateApplicantResponse.class);

        return new SuccessDataResult<UpdateApplicantResponse>(response, "Güncelleme başarı ile gerçekleşti.");
    }

    @Override
    public DataResult<?> deletedByIdApplicant(Integer id) {
        applicantRepository.deleteById(id);
        return new SuccessDataResult("İlgili ID'e sahip başvuran silindi.");
    }

    @Override
    public DataResult<?> deletedAllApplicant() {
        applicantRepository.deleteAll();
        return new SuccessDataResult("Tüm başvuranlar silindi.");
    }

}
