package com.quansun.dao;

import com.quansun.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/** 访问User的DAO */
@Repository
public class UserDao {
  private static final String MATCH_COUNT_SQL =
      "SELECT count(*) FROM t_user WHERE user_name = ? and password = ?";
  private static final String SELECT_USER_SQL =
      "SELECT user_id, user_name, credits FROM t_user WHERE user_name = ?";
  private static final String UPDATE_LOGIN_INFO_SQL =
      "UPDATE t_user SET last_visit = ?, last_ip = ?, credits = ?  WHERE user_id = ?";

  @Autowired private JdbcTemplate jdbcTemplate;

  /**
   * 根据指定用户名和密码获取匹配的用户数
   *
   * @param userName
   * @param password
   * @return
   */
  public int getMatchCount(String userName, String password) {
    return jdbcTemplate.queryForObject(
        MATCH_COUNT_SQL, new Object[] {userName, password}, Integer.class);
  }

  /**
   * 查询指定userName的User信息<br>
   * user_id, credits
   *
   * @param userName
   * @return
   */
  public User findUserByUserName(final String userName) {
    final User user = new User();
    jdbcTemplate.query(
        SELECT_USER_SQL,
        new Object[] {userName},
        (rs) -> {
          user.setUserId(rs.getInt("user_id"));
          user.setUserName(userName);
          user.setCredits(rs.getInt("credits"));
        });
    return user;
  }

  /**
   * 根据指定的userId更新该用户的登录信息
   *
   * @param user
   */
  public void updateLoginInfo(User user) {
    jdbcTemplate.update(
        UPDATE_LOGIN_INFO_SQL,
        new Object[] {user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
  }
}
