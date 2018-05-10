package com.quansun.service;

import com.quansun.dao.LoginLogDao;
import com.quansun.dao.UserDao;
import com.quansun.domain.LoginLog;
import com.quansun.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
  @Autowired private UserDao userDao;
  @Autowired private LoginLogDao loginLogDao;

  /**
   * 检查用户名密码的正确性
   *
   * @param userName
   * @param password
   * @return
   */
  public boolean hasMatchUser(String userName, String password) {
    int matchCount = userDao.getMatchCount(userName, password);
    return matchCount > 0;
  }

  public User findUserByUserName(String userName) {
    return userDao.findUserByUserName(userName);
  }

  /**
   * 登陆成功后，更新相关数据<br>
   * 添加@Transactional事务注解，让该方法运行在事务环境中
   *
   * @param user
   */
  @Transactional
  public void loginSuccess(User user) {
    user.setCredits(user.getCredits() + 5);
    LoginLog loginLog = new LoginLog();
    loginLog.setUserId(user.getUserId());
    loginLog.setIp(user.getLastIp());
    loginLog.setLoginDate(user.getLastVisit());
    userDao.updateLoginInfo(user);
    loginLogDao.insertLoginLog(loginLog);
  }
}
