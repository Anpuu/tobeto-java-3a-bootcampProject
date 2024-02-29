package tobeto.bootcamppoject.core.results.error;

import tobeto.bootcamppoject.core.results.Result;

public class ErrorResult extends Result {

    public ErrorResult(){
        super(false);
    }
    public ErrorResult(String message){
        super(false,message);
    }
}
