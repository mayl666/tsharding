package com.mogujie.service.tsharding.route;

import com.mogujie.trade.tsharding.client.ShardingCaculator;

/**
 * @author qigong on 15/9/7 下午6:16.
 */
public class SchemaPropertiesTest {

    public static void main(String[] args) {

        String[] initConfs = new String[]{
                "# testschemapressuretest master",
                "testschemapressuretest.master.url=jdbc:mysql://10.11.4.110/testschemapressuretest",
                "testschemapressuretest.master.port=3306",
                "testschemapressuretest.master.username=pigeontest",
                "testschemapressuretest.master.password=3ff143dd2bbd399a3af6349f1b46f2e2",
                "testschemapressuretest.master.minPoolSize=1",
                "testschemapressuretest.master.maxPoolSize=24",
                "testschemapressuretest.master.initialPoolSize=1"
        };

        for (long i = 0; i < 8; i++) {
            for (String conf : initConfs) {
                conf = conf.replace("testschemapressuretest", "testschemapressuretest" + ShardingCaculator.getNumberWithZeroSuffix(i));
                conf = conf.replace("sharding0", "sharding" + i/4);
                System.out.println(conf);
            }
        }
    }
}
