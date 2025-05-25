package cn.jizuiba.chain.validate;

import cn.jizuiba.chain.excepution.ValidateException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ValidatorContext {

    private final List<String> errorMessages = new ArrayList<>();
    private boolean stop = false;
    private int index = 0;
    @Getter
    private Object value;

    public ValidatorContext(Object value) {
        this.value = value;
    }

    public void appendError(String message) {
        errorMessages.add(message);
    }

    public void throwErrorNecessary() throws ValidateException {
        if (errorMessages.isEmpty()) {
            return;
        }
        throw new ValidateException(errorMessages.toString());
    }

    public void stopChain() {
        this.stop = true;
    }

    public boolean shouldStop() {
        return stop;
    }

    public void doNext(Object value) {
        index++;
        this.value = value;
    }

    public int currentIndex() {
        return index;
    }

}
