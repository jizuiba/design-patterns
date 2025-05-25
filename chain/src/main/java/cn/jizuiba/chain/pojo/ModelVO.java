package cn.jizuiba.chain.pojo;

import cn.jizuiba.chain.annotaion.Length;
import cn.jizuiba.chain.annotaion.Max;
import cn.jizuiba.chain.annotaion.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelVO {

    @Length(value = 5)
    private String modelName;

    @Max(value = 3)
    @Min(value = 5)
    private int modelSize;

    public ModelVO() {
    }

    public ModelVO(String modelName, int modelSize) {
        this.modelName = modelName;
        this.modelSize = modelSize;
    }
}
