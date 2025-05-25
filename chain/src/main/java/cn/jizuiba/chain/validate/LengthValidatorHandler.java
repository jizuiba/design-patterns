package cn.jizuiba.chain.validate;

public class LengthValidatorHandler implements ValidatorHandler {

    private final int length;

    public LengthValidatorHandler(int length) {
        this.length = length;
    }

    @Override
    public void validate(Object value, ValidatorContext context) {
        if (value instanceof String stringValue) {
            int valueLength = stringValue.length();
            if (valueLength != length) {
                context.appendError("当前值 " + valueLength + " 不满足长度为 " + length + " 的要求！");
            }
        }
    }
}
