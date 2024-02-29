package tobeto.bootcamppoject.wepapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcamppoject.core.results.DataResult;

@RestController
public class BaseController {
    public ResponseEntity<?> handleDataResult(DataResult<?> dataResult) {
        if (dataResult.isSuccess()) {
            return ResponseEntity.ok(dataResult);
        }
        return ResponseEntity.badRequest().body(dataResult);
    }
}
