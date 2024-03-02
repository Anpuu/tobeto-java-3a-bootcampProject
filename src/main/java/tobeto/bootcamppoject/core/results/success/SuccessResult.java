package tobeto.bootcamppoject.core.results.success;

import tobeto.bootcamppoject.core.results.Result;

public class    SuccessResult extends Result {
    public SuccessResult(){
        super(true);
    }

    public SuccessResult(String message){
        super(true,message);
    }
}
