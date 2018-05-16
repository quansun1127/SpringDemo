package com.quansun.domain;

import java.io.Serializable;
import java.util.Date;

/** 用户信息 */
public class User implements Serializable {

  // 用户Id
  private int userId;

  // 用户名
  private String userName;

  // 密码
  private String password;

  // 积分
  private int credits;

  // 最后一次登录的IP
  private String lastIp;

  // 最后一次登录的时间
  private Date lastVisit;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public String getLastIp() {
    return lastIp;
  }

  public void setLastIp(String lastIp) {
    this.lastIp = lastIp;
  }

  public Date getLastVisit() {
    return lastVisit;
  }

  public void setLastVisit(Date lastVisit) {
    this.lastVisit = lastVisit;
  }
}
