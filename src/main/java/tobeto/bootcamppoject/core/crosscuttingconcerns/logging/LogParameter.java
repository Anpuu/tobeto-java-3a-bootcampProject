package tobeto.bootcamppoject.core.crosscuttingconcerns.logging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogParameter {

    private Object value; // veri türü belli olmadığı için hepsinin atası olan Obeject alıyorum.


}
