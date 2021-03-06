package matrix.project.mall.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wangcheng
 * @date 2020-03-06
 */
@Data
@Accessors(chain = true)
public class AddressVo implements Serializable {

    private Long provinceCode;

    private Long cityCode;

    private Long areaCode;

    private String address;

    private String linkName;

    private String mobile;

    private Integer isDefault;
}

