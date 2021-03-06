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
public class ShopVo implements Serializable {

    private String shopId;

    private String shopName;

    private String shopLogo;

    private String shopDesc;

    private Integer shopStar;

    private Integer status;
}
