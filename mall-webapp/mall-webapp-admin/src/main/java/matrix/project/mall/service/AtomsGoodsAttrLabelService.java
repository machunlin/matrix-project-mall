package matrix.project.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import matrix.project.mall.entity.AtomsGoodsAttrLabel;
import matrix.project.mall.vo.AtomsGoodsVo;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020-02-28
 */
public interface AtomsGoodsAttrLabelService extends IService<AtomsGoodsAttrLabel> {

    List<AtomsGoodsAttrLabel> queryByAtomsGoodsId(String atomsGoodsId);

    void saveLabel(String atomsGoodsId, List<AtomsGoodsVo.AttrLabel> attrList);
}
