package com.mogujie.trade.db;

/**
 * Created by bob on 17/1/10.
 */
public interface MapperRoutingHandler {

    /**
     * 分成多少张表
     *
     * @return
     */
    int tableSize();

    /**
     * 表后缀
     *
     * @param shardingPara
     * @return
     */
    String cacuTableIndex(Long shardingPara);

    /**
     * 数据库名
     *
     * @param shardingPara
     * @return
     */
    String schemaName(Long shardingPara);

    /**
     * 表名前缀
     *
     * @return
     */
    String baseTableName();

    /**
     * 运行时获得新表名
     *
     * @return
     */
    String newTableName(Long shardingPara);

    /**
     * 计算出原方法名字
     *
     * @param method
     * @return
     */
    String methodOriginName(String method);

    class EmptyMapperRoutingHandler implements MapperRoutingHandler {
        @Override
        public int tableSize() {
            return 0;
        }

        @Override
        public String cacuTableIndex(Long shardingPara) {
            return null;
        }

        @Override
        public String schemaName(Long shardingPara) {
            return null;
        }

        @Override
        public String baseTableName() {
            return null;
        }

        @Override
        public String newTableName(Long shardingPara) {
            return null;
        }

        @Override
        public String methodOriginName(String method) {
            return null;
        }
    }
}