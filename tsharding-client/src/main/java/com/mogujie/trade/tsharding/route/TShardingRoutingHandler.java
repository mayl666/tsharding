package com.mogujie.trade.tsharding.route;

import com.mogujie.tesla.db.DataSourceRoutingHandler;
import com.mogujie.trade.tsharding.annotation.parameter.*;
import com.mogujie.trade.tsharding.client.ShardingCaculator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * @author qigong 06/05/2015
 */
public class TShardingRoutingHandler implements DataSourceRoutingHandler {

    @Override
    public String dynamicRoute(Method method, Object[] args) {
        //route逻辑见TShardingRoutingInvokeFactory
        return "testschema";
    }

    @Override
    public Collection<String> values() {
        //暂未使用
        return null;
    }
}
