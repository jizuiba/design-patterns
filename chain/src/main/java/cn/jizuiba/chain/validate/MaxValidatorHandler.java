package cn.jizuiba.chain.validate;

public class MaxValidatorHandler implements ValidatorHandler {

    private final int max;

    public MaxValidatorHandler(int max) {
        this.max = max;
    }

    @Override
    public void validate(Object value, ValidatorContext context) {
        if (value instanceof Integer intValue) {
            if (intValue > max) {
                context.appendError("当前值 " + intValue + " 大于最大值限制 " + max + " 不符合要求！");
//                context.stopChain();
            }

            context.doNext(value); // 子流程对整个主流程进行干预
        }
    }
}
