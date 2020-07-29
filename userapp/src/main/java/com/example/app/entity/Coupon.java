package com.example.app.entity;


import java.io.Serializable;
import java.util.Date;

/**
 @Description coupon 优惠券表
 @author Administrator
 @date  2020/7/16
*/
public class Coupon implements Serializable {

  private Integer id;
  private String code;
  private String title;
  private String picUrl;
  private Integer achiveAmount;
  private Integer reduceAmount;
  private Integer stock;
  private Integer status;
  private Date createTime;
  private Date updateTime;
  private String createUser;
  private String updateUser;
  private Date startTime;
  private Date endTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }


  public Integer getAchiveAmount() {
    return achiveAmount;
  }

  public void setAchiveAmount(Integer achiveAmount) {
    this.achiveAmount = achiveAmount;
  }


  public Integer getReduceAmount() {
    return reduceAmount;
  }

  public void setReduceAmount(Integer reduceAmount) {
    this.reduceAmount = reduceAmount;
  }


  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }


  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
}
