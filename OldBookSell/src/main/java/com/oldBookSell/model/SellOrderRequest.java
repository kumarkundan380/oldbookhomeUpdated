package com.oldBookSell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sell_order_request")
@SequenceGenerator(name = "seq", initialValue = 10001, allocationSize = 1)
public class SellOrderRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int sellOrderRequestId;

	@Column(name = "book_name")
	private String bookName;// title

	@Column(name = "authors")
	private String authors;

	@Column(name = "description", length = 256)
	private String description;

	@Column(name = "publisher")
	private String publisher;

	@Column(name = "publishedDate")
	private String publishedDate;

	@Column(name = "categories")
	private String categories;

	@Column(name = "isbn_type_10")
	private String isbnType10;

	@Column(name = "isbnNo1")
	private String isbnNo1;

	@Column(name = "isbn_type_13")
	private String isbnType13;

	@Column(name = "isbnNo2")
	private String isbnNo2;

	@Column(name = "smallThumbnail")
	private String smallThumbnail;// small image size

	@Column(name = "thumbnail")
	private String thumbnail;// large image size

	@Column(name = "amount")
	private float amount;

	@Column(name = "currencyCode")
	private String currencyCode;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "check_status", columnDefinition = "BOOLEAN")
	private Boolean checkStatus;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "address_id")
	private String addressId;

	public int getSellOrderRequestId() {
		return sellOrderRequestId;
	}

	public void setSellOrderRequestId(int sellOrderRequestId) {
		this.sellOrderRequestId = sellOrderRequestId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getIsbnType10() {
		return isbnType10;
	}

	public void setIsbnType10(String isbnType10) {
		this.isbnType10 = isbnType10;
	}

	public String getIsbnNo1() {
		return isbnNo1;
	}

	public void setIsbnNo1(String isbnNo1) {
		this.isbnNo1 = isbnNo1;
	}

	public String getIsbnType13() {
		return isbnType13;
	}

	public void setIsbnType13(String isbnType13) {
		this.isbnType13 = isbnType13;
	}

	public String getIsbnNo2() {
		return isbnNo2;
	}

	public void setIsbnNo2(String isbnNo2) {
		this.isbnNo2 = isbnNo2;
	}

	public String getSmallThumbnail() {
		return smallThumbnail;
	}

	public void setSmallThumbnail(String smallThumbnail) {
		this.smallThumbnail = smallThumbnail;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Boolean getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Boolean checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public SellOrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
