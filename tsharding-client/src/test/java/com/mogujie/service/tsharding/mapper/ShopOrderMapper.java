package com.mogujie.service.tsharding.mapper;

import com.mogujie.service.tsharding.bean.ShopOrder;
import com.mogujie.trade.db.DataSourceRouting;
import com.mogujie.trade.db.MapperRoutingHandler;
import com.mogujie.trade.tsharding.annotation.ShardingExtensionMethod;
import com.mogujie.trade.tsharding.annotation.parameter.ShardingOrderPara;
import com.mogujie.trade.tsharding.route.TShardingRoutingHandler;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import static com.mogujie.trade.tsharding.client.ShardingCaculator.getNumberWithZeroSuffix;

@DataSourceRouting(handler = TShardingRoutingHandler.class, mapper = ShopOrderMapper.ShopOrderMapperRouting.class)
public interface ShopOrderMapper {

    @ShardingExtensionMethod
    ShopOrder getShopOrderByShopOrderId(@ShardingOrderPara Long shopOrderId);

    @ShardingExtensionMethod
    List<ShopOrder> getShopOrderByShopOrderIds(@ShardingOrderPara List<Long> shopOrderIds);

    @ShardingExtensionMethod
    int batchUpdateShopOrderByShopOrderIds(@ShardingOrderPara @Param("shopOrderIds") List<Long> shopOrderIds, @Param("shopOrder") ShopOrder shopOrder);

    class ShopOrderMapperRouting implements MapperRoutingHandler {
        @Override
        public int tableSize() {
            return 512;
        }

        @Override
        public String cacuTableIndex(Long shardingPara) {
            return getNumberWithZeroSuffix((shardingPara % 10000) % 512);
        }

        @Override
        public String SchemaName(Long shardingPara) {
            return "trade" + getNumberWithZeroSuffix(((shardingPara % 10000) % 512) / 64);
        }

        @Override
        public String baseTableName() {
            return "TradeOrder";
        }

        @Override
        public String newTableName(Long shardingPara) {
            return baseTableName() + cacuTableIndex(shardingPara);
        }

        @Override
        public String methodOriginName(String method) {
            return method.substring(0, method.length() - 4);
        }
    }
}