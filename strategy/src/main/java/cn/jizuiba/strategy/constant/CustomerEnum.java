package cn.jizuiba.strategy.constant;

import java.util.function.IntPredicate;

public enum CustomerEnum {
    DEFAULT(recharge -> recharge < 100),
    NORMAL(recharge -> recharge >= 100 && recharge <= 1000),
    HIGH(recharge -> recharge >= 1000 && recharge <= 10000),
    PERSONAL(recharge -> recharge >= 10000);

    private final IntPredicate support;

    CustomerEnum(IntPredicate support) {
        this.support = support;
    }

    public static CustomerEnum typeOf(int recharge) {
        for (CustomerEnum value : values()) {
            if (value.support.test(recharge)) {
                return value;
            }
        }
        return null;
    }
}
