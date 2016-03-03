package com.mogujie.service.tsharding.route;

import com.mogujie.service.tsharding.route.dal.ShopOrder;
import com.mogujie.service.tsharding.route.dal.ShopOrderMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class ShopOrderMapperTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private ShopOrderMapper shopOrderMapper;

    @Before
    public void setUp() throws Exception {
        this.applicationContext = new ClassPathXmlApplicationContext("META-INF/tesla/support/service-loader.xml",
                "META-INF/tesla/support/datasource.xml");
        this.shopOrderMapper = applicationContext.getBean(ShopOrderMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        this.applicationContext.close();
    }


    @Test
    public void testXdOrderSharding() {

        ShopOrder shopOrder = null;
        try {
            shopOrder = shopOrderMapper.getShopOrderByShopOrderId(3950627820824L);
            logger.debug("{}", shopOrder);
            Assert.assertNotNull(shopOrder);

            shopOrder = shopOrderMapper.getShopOrderByShopOrderId(3950627820002L);
            logger.debug("{}", shopOrder);
            Assert.assertNull(shopOrder);

//            List<ShopOrder> shopOrders = shopOrderMapper.getShopOrderByShopOrderIdsOfOneBuyer(Arrays.asList(new Long[]{3950627820824L,3950631130824L}));
//            logger.debug("{}", shopOrders);
//            Assert.assertEquals(2, shopOrders.size());


//            Assert.assertEquals(new Integer(0), xdShopOrder.getVisible());
//            xdShopOrder.setVisible(1);
//            xdShopOrderMapperPart1.updateShopOrderByShopOrderIdAndStatus(xdShopOrder.getOrderId(),xdShopOrder, xdShopOrder.getStatus());
//            xdShopOrder = xdShopOrderMapper.getShopOrderByShopOrderId(3950627820824L);
//            logger.debug("after update visible:{}", xdShopOrders);
//            Assert.assertEquals(new Integer(1), xdShopOrder.getVisible());
//
//            xdShopOrder.setVisible(0);
//            xdShopOrderMapperPart1.updateShopOrderByShopOrderIdAndStatus(xdShopOrder.getOrderId(),xdShopOrder, xdShopOrder.getStatus());
//            xdShopOrder = xdShopOrderMapper.getShopOrderByShopOrderId(3950627820824L);
//            Assert.assertEquals(new Integer(0), xdShopOrder.getVisible());

//            xdShopOrders = xdShopOrderMapperPart1.getShopOrdersByPayOrderIdsOfOneBuyer(Arrays.asList(new Long[]{3950627810824L, 3950631120824L}));
//            logger.debug("{}", xdShopOrders);
//            Assert.assertEquals(2, xdShopOrders.size());
//
//            Long payOrderId = 3971291360824L;
//            XdShopOrder record = new XdShopOrder();
//            record.setParentOrderId(payOrderId);
//            record.setStatus(1 /*BusinessConstants.ORDER_STATUS_CANCELED*/);
//            Long now  = (System.currentTimeMillis() / 1000);
//            record.setCancelTime(now);
//            record.setCancelReason("ddd");
//            record.setExpiredTime(1L);
//            record.setUpdated(1L);
//            xdShopOrderMapper.batchUpdateShopOrderByShopOrderIdsAndStatusOfOneBuyer(Arrays.asList(new Long[]{3971291380824L, 3971291370824L}), record, record.getStatus());
//            xdShopOrder = xdShopOrderMapper.getShopOrderByShopOrderId(3971291380824L);
//            logger.debug("{}", xdShopOrder);
//            Assert.assertEquals(now, xdShopOrder.getCancelTime());
//
//
//            //updateShipExpenseByShopOrderId
//            xdShopOrder.setOrderId(3981357789949L);
//            xdShopOrder.setShipExpense(1200L);
//            xdShopOrderMapper.updateShopOrderByShopOrderId(xdShopOrder.getOrderId(), xdShopOrder);
//            xdShopOrder = xdShopOrderMapper.getShopOrderByShopOrderId(3981357789949L);
//            logger.debug("{}", xdShopOrder);
//            Assert.assertEquals(new Long(1200), xdShopOrder.getShipExpense());
//
//
//            //扫单表
//            xdShopOrders = xdShopOrderMapper.getOrdersByUpdatedTime(181,1430740105L, 1430833654L);
//            logger.debug("{}", xdShopOrders);
//            Assert.assertTrue(xdShopOrders.size() >  1);

        } catch (Exception e) {
            logger.error("test error", e);
        }

    }


}
