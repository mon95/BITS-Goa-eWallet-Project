package e_wallet;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

    /**
     *
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
      Student student = new Student();
      student.setId(rs.getInt("id"));
      student.setName(rs.getString("name"));
      student.setBits_id(rs.getString("bits_id"));
      student.setPassword(rs.getString("password"));
      student.setPIN(rs.getInt("pin"));
      student.setEWBalance(rs.getDouble("ewbalance"));
      student.setCredit_avail(rs.getDouble("credit_avail"));
      student.setSwdbalance(rs.getDouble("swdbalance"));
      student.setLoyaltyBonus(rs.getInt("lb"));
      return student;
   }
}