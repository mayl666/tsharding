package com.mogujie.service.tsharding.route.dal;

import com.mogujie.trade.tsharding.client.ShardingCaculator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @auther qigong on 6/5/15 8:52 PM.
 */
public class ShopOrderDaoImpl implements ShopOrderDao {

    @Autowired
    private ShopOrderMapper shopOrderMapper;

    @Override
    public List<ShopOrder> getShopOrderByShopOrderIdsOfOneBuyer(List<Long> listShopOrderIds) {
        if (listShopOrderIds == null || listShopOrderIds.size() == 0) {
            return null;
        }
        Set<Long> setShopOrderIds = new HashSet<Long>();
        for (Long iShopOrderId : listShopOrderIds) {
            if (iShopOrderId > 0) {
                setShopOrderIds.add(iShopOrderId);
            }
        }
        return shopOrderMapper.getShopOrderByShopOrderIdsOfOneBuyer(new ArrayList<Long>(setShopOrderIds));
    }


    @Override
    public List<ShopOrder> getShopOrderByShopOrderIdsOfMultiBuyer(List<Long> listShopOrderIds) {
        if (listShopOrderIds == null || listShopOrderIds.size() == 0) {
            return null;
        }
        HashMap<Integer, List<Long>> shopOrderIdsMap = new HashMap();
        for (Long shopOrderId : listShopOrderIds) {
            Integer tableIndex = ShardingCaculator.caculateTableIndex(shopOrderId);
            List<Long> orderIds = shopOrderIdsMap.get(tableIndex);
            if (orderIds == null) {
                orderIds = new ArrayList<>();
            }
            orderIds.add(shopOrderId);
            shopOrderIdsMap.put(tableIndex, orderIds);
        }
        List<ShopOrder> result = new ArrayList<>();

        for (Integer tableIndex : shopOrderIdsMap.keySet()) {
            result.addAll(shopOrderMapper.getShopOrderByShopOrderIdsOfOneBuyer(shopOrderIdsMap.get(tableIndex)));
        }
        return result;
    }
}
