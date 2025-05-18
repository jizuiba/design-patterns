package cn.jizuiba.strategy.controller;

import cn.jizuiba.strategy.constant.CustomerEnum;
import cn.jizuiba.strategy.service.CustomerFactory;
import cn.jizuiba.strategy.service.CustomerService;
import cn.jizuiba.strategy.service.impl.DefaultCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerFactory customerAbstractFactory;
    @Autowired
    private DefaultCustomerService defaultCustomerService;

    @GetMapping("/customer")
    public String customer(int recharge) {
        CustomerEnum customer = CustomerEnum.typeOf(recharge);
        CustomerService customerService = customerAbstractFactory.customerServiceMap
                .getOrDefault(customer, defaultCustomerService);
        return customerService.findCustomer();
    }
}
