package com.quansun.dao;

import com.quansun.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/** 访问LoginLog的DAO */
@Repository
public class LoginLogDao {
  @Autowired private JdbcTemplate jdbcTemplate;

  private static final String INSERT_LOGIN_LOG_SQL =
      "INSERT INTO t_login_log(user_id, ip, login_datetime) VALUES(?, ?, ?)";

  /**
   * 保存登陆日志
   *
   * @param loginLog
   */
  public void insertLoginLog(LoginLog loginLog) {
    jdbcTemplate.update(
        INSERT_LOGIN_LOG_SQL,
        new Object[] {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()});
  }
}
