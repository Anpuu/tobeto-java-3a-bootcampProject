package tobeto.bootcamppoject.wepapi;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.BlacklistService;
import tobeto.bootcamppoject.business.dto.create.blacklist.request.CreateBlacklistRequest;
import tobeto.bootcamppoject.business.dto.update.blacklist.request.UpdateBlacklistRequest;

@RestController
@RequestMapping("/blacklists")
@AllArgsConstructor
public class BlacklistController extends BaseController{
    private BlacklistService blacklistService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateBlacklistRequest request) {
        return handleDataResult(blacklistService.add(request));
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return handleDataResult(blacklistService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return handleDataResult(blacklistService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return handleDataResult(blacklistService.delete(id));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody UpdateBlacklistRequest request) {
        return handleDataResult(blacklistService.update(request));
    }
}
