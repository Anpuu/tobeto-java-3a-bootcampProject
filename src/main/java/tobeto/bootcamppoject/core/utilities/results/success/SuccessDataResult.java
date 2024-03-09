package tobeto.bootcamppoject.core.utilities.results.success;

import tobeto.bootcamppoject.core.utilities.results.DataResult;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data, String message) {
        super(data, true, message); // data vardır, doğru çalışmıştır, mesaj da vardır.!
    }

    public SuccessDataResult(T data) {
        super(data, true); // data vardır(null değildir.) ve doğru çalışmıştır.
    }

    public SuccessDataResult(String message) {
        super(null, true, message); // elimde veri yoktur ve istek doğru çalışmıştır. bu yüzden boş method gelebilir.
    }

    public SuccessDataResult() {
        super(null, true);
    }
}
