package cn.jizuiba.chain.validate;

import cn.jizuiba.chain.annotaion.Length;
import cn.jizuiba.chain.annotaion.Max;
import cn.jizuiba.chain.annotaion.Min;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ValidatorHandlerFactory {
    private static final Map<Class<? extends Annotation>, Function<Annotation, ValidatorHandler>> HANDLER_MAPPINGS = new HashMap<>();

    static {
        HANDLER_MAPPINGS.put(Max.class, annotation -> new MaxValidatorHandler(((Max) annotation).value()));
        HANDLER_MAPPINGS.put(Min.class, annotation -> new MinValidatorHandler(((Min) annotation).value()));
        HANDLER_MAPPINGS.put(Length.class, annotation -> new LengthValidatorHandler(((Length) annotation).value()));
    }

    public static ValidatorHandler createHandler(Annotation annotation) {
        Function<Annotation, ValidatorHandler> handlerFunction = HANDLER_MAPPINGS.get(annotation.annotationType());
        return handlerFunction != null ? handlerFunction.apply(annotation) : null;
    }
}
