package com.mogujie.service.tsharding.route.dal;

/**
 * @author xueyan on 15/1/19.
 */
public class ShopOrder extends BaseOrder {

    /**
     * 父订单ID
     */
    private Long parentOrderId;

    /**
     * 订单级别, 0: 商品级; 1: 店铺级
     */
    private final Integer level = 1;

    /**
     * 卖家的userId
     */
    private Long sellerUserId;

    /**
     * 交易流程类型, 0: 全款交易，1: 二阶段预售
     */
    private Integer processType;

    /**
     * 快递费用
     */
    private Long shipExpense;

    /**
     * 店铺级订单:店铺优惠; 支付级订单: 平台优惠
     */
    private Long promotionAmount;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 订单扩展状态
     */
    private Integer statusEx;

    /**
     * 是否可见, 0: 可见 1: 不可见
     */
    private Integer visible;

    /**
     * 发货时间
     */
    private Long shipTime;

    /**
     * 确认收货时间
     */
    private Long receiveTime;

    /**
     * 确认收货触发类型, 0: 买家触发，1: 快递签收触发(自动), 2: 超时触发(自动)
     */
    private Integer receiveType;

    /**
     * 评论状态
     */
    private Integer rateFromBuyerVisible;

    /**
     * 取消订单时间, 如果取消与支付回调同时发生则优先考虑支付相关状态(取消时间为0)
     */
    private Long cancelTime;

    /**
     * 结算时间
     */
    private Long settlementTime;

    /**
     * 取消原因
     */
    private String cancelReason;

    /**
     * 买家备注
     */
    private String buyerComment;

    /**
     * 卖家备注
     */
    private String sellerComment;

    /**
     * 订单逆向流程状态
     */
    private Integer reverseStatus;


    public static ShopOrder getInstance() {
        return new ShopOrder();
    }

    public Long getParentOrderId() {
        return this.parentOrderId;
    }

    public void setParentOrderId(Long parentOrderId) {
        this.parentOrderId = parentOrderId;
    }

    public Integer getLevel() {
        return level;
    }

    public Long getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(Long sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public Integer getProcessType() {
        return processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    public Long getShipExpense() {
        return shipExpense;
    }

    public void setShipExpense(Long shipExpense) {
        this.shipExpense = shipExpense;
    }

    public Long getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(Long promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatusEx() {
        return statusEx;
    }

    public void setStatusEx(Integer statusEx) {
        this.statusEx = statusEx;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Long getShipTime() {
        return shipTime;
    }

    public void setShipTime(Long shipTime) {
        this.shipTime = shipTime;
    }

    public Long getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Long receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(Integer receiveType) {
        this.receiveType = receiveType;
    }

    public Integer getRateFromBuyerVisible() {
        return rateFromBuyerVisible;
    }

    public void setRateFromBuyerVisible(Integer rateFromBuyerVisible) {
        this.rateFromBuyerVisible = rateFromBuyerVisible;
    }

    public Long getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Long cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Long getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(Long settlementTime) {
        this.settlementTime = settlementTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getBuyerComment() {
        return buyerComment;
    }

    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }

    public String getSellerComment() {
        return sellerComment;
    }

    public void setSellerComment(String sellerComment) {
        this.sellerComment = sellerComment;
    }

    public Integer getReverseStatus() {
        return reverseStatus;
    }

    public void setReverseStatus(Integer reverseStatus) {
        this.reverseStatus = reverseStatus;
    }

    @Override
    public String toString() {
        return "XdShopOrder{" +
                "parentOrderId=" + parentOrderId +
                ", level=" + level +
                ", sellerUserId=" + sellerUserId +
                ", processType=" + processType +
                ", shipExpense=" + shipExpense +
                ", promotionAmount=" + promotionAmount +
                ", status=" + status +
                ", statusEx=" + statusEx +
                ", visible=" + visible +
                ", shipTime=" + shipTime +
                ", receiveTime=" + receiveTime +
                ", receiveType=" + receiveType +
                ", rateFromBuyerVisible=" + rateFromBuyerVisible +
                ", cancelTime=" + cancelTime +
                ", settlementTime=" + settlementTime +
                ", cancelReason='" + cancelReason + '\'' +
                ", buyerComment='" + buyerComment + '\'' +
                ", sellerComment='" + sellerComment + '\'' +
                ", reverseStatus=" + reverseStatus +
                "} " + super.toString();
    }
}
