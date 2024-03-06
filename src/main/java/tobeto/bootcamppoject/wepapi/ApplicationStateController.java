package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.ApplicationStateService;
import tobeto.bootcamppoject.business.dto.create.applicationstate.request.CreateApplicationStateRequest;
import tobeto.bootcamppoject.business.dto.update.application.request.UpdateApplicationRequest;
import tobeto.bootcamppoject.business.dto.update.applicationState.request.UpdateApplicationStateRequest;
import tobeto.bootcamppoject.core.aspects.logging.Loggable;

@RestController
@RequestMapping("/applicationstate")
@RequiredArgsConstructor
public class ApplicationStateController extends BaseController {

    private final ApplicationStateService applicationStateService;

    @Loggable
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final CreateApplicationStateRequest createApplicationStateRequest
    ) {
        return handleDataResult(applicationStateService.create(createApplicationStateRequest));
    }

    @Loggable
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(
            @PathVariable final Integer id
    ) {
        return handleDataResult(applicationStateService.getById(id));
    }

    @Loggable
    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(applicationStateService.getAll());
    }

    public ResponseEntity<?> updateById(
            @RequestBody final UpdateApplicationStateRequest updateApplicationStateRequest,
            @PathVariable final Integer id
    ) {
        return handleDataResult(applicationStateService.updateApplicantState(updateApplicationStateRequest, id));
    }

    @Loggable
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(
            @PathVariable final Integer id
    ) {
        return handleDataResult(applicationStateService.deletedApplication(id));
    }
}
