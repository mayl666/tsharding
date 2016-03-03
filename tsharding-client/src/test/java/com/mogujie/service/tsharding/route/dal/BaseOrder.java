package com.mogujie.service.tsharding.route.dal;

/**
 * @author xueyan on 15/1/19.
 */
public abstract class BaseOrder {

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 买家的userId
     */
    private Long buyerUserId;

    /**
     * 订单类型
     */
    private Integer type;

    /**
     * 商品级订单: 商品数量; 店铺级订单: 子商品级订单所有商品数量总和
     */
    private Integer number;

    /**
     * 商品级订单: 订单价格(计算商品打折), 店铺级订单: 子商品级订单价格总和(计算店铺优惠)
     */
    private Long price;

    /**
     * 促销详情:例如促销单号...
     */
    private String promotion;

    /**
     * 支付时间, 未支付时为空或NULL
     */
    private Long payTime;

    /**
     * 支付ID
     */
    private Long payId;
    /**
     * 订单当前状态的超时时刻
     */
    private Long expiredTime;

    /**
     * 下单平台类型, 0: PC; 1000000: APP
     */
    private Integer platformType;

    /**
     * 来源类型，用于来源跟踪
     */
    private String source;

    /**
     * 自定义扩展信息
     */
    private String extra;

    /**
     * 自定义扩展信息
     */
    private Long extraInt;

    /**
     * 创建时间
     */
    private Long created;

    /**
     * 更新时间
     */
    private Long updated;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Long getExtraInt() {
        return extraInt;
    }

    public void setExtraInt(Long extraInt) {
        this.extraInt = extraInt;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "XdBaseOrder{" +
                "orderId=" + orderId +
                ", buyerUserId=" + buyerUserId +
                ", type=" + type +
                ", number=" + number +
                ", price=" + price +
                ", promotion='" + promotion + '\'' +
                ", payTime=" + payTime +
                ", payId=" + payId +
                ", expiredTime=" + expiredTime +
                ", platformType=" + platformType +
                ", source='" + source + '\'' +
                ", extra='" + extra + '\'' +
                ", extraInt=" + extraInt +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
