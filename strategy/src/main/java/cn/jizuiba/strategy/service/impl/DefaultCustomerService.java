package cn.jizuiba.strategy.service.impl;

import cn.jizuiba.strategy.annotation.SupportCustomerAnnotation;
import cn.jizuiba.strategy.constant.CustomerEnum;
import cn.jizuiba.strategy.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
@SupportCustomerAnnotation(type = CustomerEnum.DEFAULT)
public class DefaultCustomerService implements CustomerService {

    @Override
    public CustomerEnum support() {
        return CustomerEnum.DEFAULT;
    }

    public String findCustomer() {
        return "默认回复，不存在对应客服";
    }
}
