package matrix.project.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import matrix.project.mall.dto.ItemDto;
import matrix.project.mall.dto.OrderDto;
import matrix.project.mall.entity.Order;
import matrix.project.mall.entity.OrderGoods;
import matrix.project.mall.vo.OrderAddressVo;
import matrix.project.mall.vo.QueryOrderVo;
import matrix.project.mall.vo.ShipVo;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020-03-06
 */
public interface OrderService extends IService<Order> {

    List<ItemDto> orderStatus();

    Integer countOrder(QueryOrderVo queryOrderVo);

    List<OrderDto> listOrder(QueryOrderVo queryOrderVo);

    boolean saveOrderAddress(OrderAddressVo orderAddressVo);

    Order queryByOrderId(String orderId);

    List<OrderGoods> listOrderGoods(String orderId);

    boolean saveShip(ShipVo shipVo);

    boolean cancelOrder(String orderId);

    List<Order> queryByOrderIds(List<String> orderIds);
}
