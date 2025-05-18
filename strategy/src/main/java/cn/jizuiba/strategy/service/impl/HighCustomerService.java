package cn.jizuiba.strategy.service.impl;

import cn.jizuiba.strategy.annotation.SupportCustomerAnnotation;
import cn.jizuiba.strategy.constant.CustomerEnum;
import cn.jizuiba.strategy.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
@SupportCustomerAnnotation(type = CustomerEnum.HIGH)
public class HighCustomerService implements CustomerService {

    @Override
    public CustomerEnum support() {
        return CustomerEnum.HIGH;
    }

    @Override
    public String findCustomer() {
        return "高级客服";
    }
}
