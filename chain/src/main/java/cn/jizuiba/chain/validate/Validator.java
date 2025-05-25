package cn.jizuiba.chain.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Validator {

    public void validate(Object bean) throws Exception {
        Class<?> beanClass = bean.getClass();
        for (Field field : beanClass.getDeclaredFields()) {
            field.setAccessible(true);
            ValidatorChain chain = buildValidatorChain(field);
            chain.validate(field.get(bean));
        }
    }

    private ValidatorChain buildValidatorChain(Field field) {
        ValidatorChain chain = new ValidatorChain();

        for (Annotation annotation : field.getAnnotations()) {
            ValidatorHandler handler = ValidatorHandlerFactory.createHandler(annotation);
            if (handler != null) {
                chain.addLastHandler(handler);
            }
        }

        return chain;
    }
}
