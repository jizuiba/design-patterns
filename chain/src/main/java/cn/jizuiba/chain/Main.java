package cn.jizuiba.chain;

import cn.jizuiba.chain.pojo.ModelVO;
import cn.jizuiba.chain.validate.Validator;

public class Main {

    public static void main(String[] args) throws Exception {
        ModelVO model = new ModelVO("模型1", 4);

        Validator validator = new Validator();
        validator.validate(model);
    }
}
