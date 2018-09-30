package com.unclewoo.bean;

import java.util.ArrayList;
import java.util.List;

import com.unclewoo.bean.book.OrderContactInfo;
import com.unclewoo.bean.book.OrderDeliverInfo;
import com.unclewoo.bean.book.PaymentWayInfo;

/**
 * 购物车
 * @author King
 *
 */
public class BuyCart {
	/* 购物项 */
	private List<BuyItem> items = new ArrayList<BuyItem>();
	/* 售后人配送信息 */
	private OrderDeliverInfo deliverInfo;
	/* 订购者联系信息 */
	private OrderContactInfo contactInfo;
	/* 收货人 与订购者是否相同   */
	private Boolean buyerIsrecipients;
	/* 支付方式信息  */
	private PaymentWayInfo paymentWayInfo;
	/* 配送费   */
	private float deliverFee = 10f;
	/* 附言  */
	private String note;
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<BuyItem> getItems() {
		return items;
	}

	public void setItems(List<BuyItem> items) {
		this.items = items;
	}
	
	public OrderDeliverInfo getDeliverInfo() {
		return deliverInfo;
	}

	public void setDeliverInfo(OrderDeliverInfo deliverInfo) {
		this.deliverInfo = deliverInfo;
	}

	public OrderContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(OrderContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public Boolean getBuyerIsrecipients() {
		return buyerIsrecipients;
	}

	public void setBuyerIsrecipients(Boolean buyerIsrecipients) {
		this.buyerIsrecipients = buyerIsrecipients;
	}
	
	public PaymentWayInfo getPaymentWayInfo() {
		return paymentWayInfo;
	}

	public void setPaymentWayInfo(PaymentWayInfo paymentWayInfo) {
		this.paymentWayInfo = paymentWayInfo;
	}

	public float getDeliverFee() {
		return deliverFee;
	}

	public void setDeliverFee(float deliverFee) {
		this.deliverFee = deliverFee;
	}

	/**
	 * 添加购物项
	 * @param item
	 */
	public void addItem(BuyItem item){
		if(!items.contains(item)){
			items.add(item);
		}else{//如果已经存在该购物项，就累加其购物项
			for(BuyItem bi :items){
				if(bi.equals(item)){
					bi.setAmount(bi.getAmount()+1);
					break;
				}
			}
		}
	}
	
	/**
	 * 清除购物车，删除所有购物项
	 */
	public void removeAll(){
		items.clear();
	}
	
	/**
	 * 删除购物项
	 * @param item
	 */
	public void removeBuyItem(BuyItem item){
		if(items.contains(item)){
			items.remove(item);
		}
	}
	
	/**
	 * 更新购买数量
	 * @param item
	 */
	public void updateAmount(BuyItem item){
		for(BuyItem bi :items){
			if(bi.equals(item)){
				bi.setAmount(item.getAmount());
				break;
			}
		}
	}
	
	/**
	 * 批量更新购买数量
	 * @param item
	 */
	public void updateAmount(BuyItem[] items){
		for(BuyItem bi : this.items){
			for(BuyItem item : items){
				if(bi.equals(item)){
					bi.setAmount(item.getAmount());
					break;
				}
			}
		}
	}
	
	/**
	 * 获取应付总金额
	 * @return
	 */
	public float getTotalPrice(){
		float total = 0;
		for(BuyItem bi : this.items){
			total += bi.getProduct().getSellprice()*bi.getAmount();
		}
		return total;
	}
	
	/**
	 *  获取市场价总金额
	 * @return
	 */
	public float getTotalMarketPrice(){
		float total = 0;
		for(BuyItem bi : this.items){
			total += bi.getProduct().getMarketprice()*bi.getAmount();
		}
		return total;
	}
	
	/**
	 *  总节省金额
	 * @return
	 */
	public float getTotalSavedPrice(){
		return getTotalMarketPrice() - getTotalPrice();
	}
	
	/**
	 * 订单总金额
	 * @return
	 */
	public float getOrderTotalPrice(){
		return getTotalPrice() + getDeliverFee();
	}
}
