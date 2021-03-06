package matrix.project.mall.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wangcheng
 * @date 2020-03-01
 */
@Data
@Accessors(chain = true)
public class BrandVo implements Serializable {

    private String brandId;

    private String brandName;

    private String brandUrl;

    private String brandLogo;

}
