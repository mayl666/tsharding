package com.mogujie.service.tsharding.route;

import com.mogujie.service.tsharding.route.dal.ShopOrder;
import com.mogujie.service.tsharding.route.dal.ShopOrderDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther qigong on 6/5/15 8:55 PM.
 */
public class ShopOrderDaoTest {

    @Autowired
    private ShopOrderDao shopOrderDao;

    @Test
    public void testGetShopOrderByShopOrderIdsOfOneBuyer() {

        List<Long> listShopOrderIds = new ArrayList<>();
        listShopOrderIds.add(3968484880824L);
        listShopOrderIds.add(3968484880824L);

        List<ShopOrder> shopOrders = shopOrderDao.getShopOrderByShopOrderIdsOfOneBuyer(listShopOrderIds);
        Assert.assertTrue(shopOrders.size() == 2);
    }
}
