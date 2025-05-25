package cn.jizuiba.chain.validate;

import cn.jizuiba.chain.excepution.ValidateException;

import java.util.ArrayList;
import java.util.List;

public class ValidatorChain {

    private final List<ValidatorHandler> validatorHandlers = new ArrayList<>();


    public void validate(Object value) throws ValidateException {
        /*for (ValidatorHandler handler : validatorHandlers) {
            handler.validate(value, context);
            if (context.shouldStop()) {
                break;
            }
        }*/
        ValidatorContext context = new ValidatorContext(value);

        while (true) {
            int index = context.currentIndex();

            if (index == validatorHandlers.size()) {
                break;
            }

            ValidatorHandler handler = validatorHandlers.get(index);
            handler.validate(context.getValue(), context);

            if (index == context.currentIndex()) {
                break;
            }
        }

        context.throwErrorNecessary();
    }

    public void addLastHandler(ValidatorHandler handler) {
        validatorHandlers.add(handler);
    }

}
