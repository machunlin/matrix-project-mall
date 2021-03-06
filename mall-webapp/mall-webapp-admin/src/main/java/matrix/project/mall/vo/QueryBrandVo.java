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
public class QueryBrandVo implements Serializable {

    private String brandName;

    private Integer page;

    private Integer pageSize;
}
