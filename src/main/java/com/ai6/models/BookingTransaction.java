package com.ai6.models;

import com.ai6.utils.CAB_SERVICE;

/**
 * Created by bharath on 4/27/17.
 */
public class BookingTransaction {

  private String bookingId;
  private CAB_SERVICE service;
  private Address fromAddress;
  private Address toAddress;
  private boolean transactionStatus;
  private Double cost;
  //Secs?
  private Double time;

  public BookingTransaction() {
  }

  public boolean isTransactionStatus() {
    return transactionStatus;
  }

  public void setTransactionStatus(boolean transactionStatus) {
    this.transactionStatus = transactionStatus;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Double getTime() {
    return time;
  }

  public void setTime(Double time) {
    this.time = time;
  }

  public String getBookingId() {
    return bookingId;
  }

  public void setBookingId(String bookingId) {
    this.bookingId = bookingId;
  }

  public Address getFromAddress() {
    return fromAddress;
  }

  public void setFromAddress(Address fromAddress) {
    this.fromAddress = fromAddress;
  }

  public CAB_SERVICE getService() {
    return service;
  }

  public void setService(CAB_SERVICE service) {
    this.service = service;
  }

  public Address getToAddress() {
    return toAddress;
  }

  public void setToAddress(Address toAddress) {
    this.toAddress = toAddress;
  }
}
