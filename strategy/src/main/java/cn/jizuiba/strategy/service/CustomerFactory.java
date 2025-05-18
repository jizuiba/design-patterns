package cn.jizuiba.strategy.service;

import cn.jizuiba.strategy.annotation.SupportCustomerAnnotation;
import cn.jizuiba.strategy.constant.CustomerEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CustomerFactory {
    public Map<CustomerEnum, CustomerService> customerServiceMap = new HashMap<>();

    @Autowired
    public void init(List<CustomerService> customerServices) {
        customerServiceMap = customerServices.stream()
                .filter(customerService -> customerService.getClass().isAnnotationPresent(SupportCustomerAnnotation.class))
                .collect(Collectors.toMap(customerService -> customerService.getClass().getAnnotation(SupportCustomerAnnotation.class).type(), Function.identity()));

        if (customerServiceMap.size() != CustomerEnum.values().length) {
            throw new IllegalArgumentException("存在客服类型无对应处理逻辑。");
        }
    }
}
