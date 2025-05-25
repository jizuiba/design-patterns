package cn.jizuiba.chain.validate;

public class MinValidatorHandler implements ValidatorHandler {

    private final int min;

    public MinValidatorHandler(int min) {
        this.min = min;
    }

    @Override
    public void validate(Object value, ValidatorContext context) {
        if (value instanceof Integer intValue) {
            if (intValue < min) {
                context.appendError("当前值 " + intValue + " 小于最小值限制 " + min + " 不符合要求！");
            }
        }
    }
}
