package matrix.project.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import matrix.module.jdbc.annotation.TargetDataSource;
import matrix.project.mall.dto.ApiOrderDto;
import matrix.project.mall.dto.OrderDto;
import matrix.project.mall.entity.Order;
import matrix.project.mall.vo.QueryOrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020-03-06
 */
@Mapper
@TargetDataSource
public interface OrderMapper extends BaseMapper<Order> {

    List<OrderDto> listOrder(IPage<Order> page, @Param("item") QueryOrderVo queryOrderVo, @Param("shopId") String shopId);

    void processPayedOrderIds(@Param("orderIds") List<String> orderIds,
                              @Param("currentOrderStatus") Integer currentOrderStatus,
                              @Param("processOrderStatus") Integer processOrderStatus);

    List<ApiOrderDto> queryOrderList(IPage<Order> page, @Param("userId") String userId);

    List<ApiOrderDto.OrderGoodsDto> queryOrderGoodsList(@Param("orderIds") List<String> orderIds);
}
