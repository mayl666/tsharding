package com.mogujie.service.tsharding.route.dal;

import com.mogujie.tesla.db.DataSourceRouting;
import com.mogujie.trade.tsharding.annotation.ShardingExtensionMethod;
import com.mogujie.trade.tsharding.annotation.parameter.ShardingOrderPara;
import com.mogujie.trade.tsharding.route.TShardingRoutingHandler;
import com.mogujie.trade.tsharding.route.orm.MapperResourceEnhancer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@DataSourceRouting(handler=TShardingRoutingHandler.class)
public  interface ShopOrderMapper {
    @ShardingExtensionMethod(type = MapperResourceEnhancer.class, method = "enhancedShardingSQL")
    public ShopOrder getShopOrderByShopOrderId(@ShardingOrderPara("orderId") Long shopOrderId);

    @ShardingExtensionMethod(type = MapperResourceEnhancer.class, method = "enhancedShardingSQL")
    public List<ShopOrder> getShopOrderByShopOrderIdsOfOneBuyer(@ShardingOrderPara("orderId") List<Long> xdShopOrderIds);

}