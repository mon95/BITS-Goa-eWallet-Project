package e_wallet;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VendorMapper implements RowMapper<Vendor> {

    /**
     *
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
	public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Vendor vendor = new Vendor();
	      vendor.setId(rs.getInt("id"));
	      vendor.setName(rs.getString("name"));
	      vendor.setUname(rs.getString("uname"));
	      vendor.setPassword(rs.getString("password"));
	      vendor.setEwbalance(rs.getDouble("ewbalance"));
	      return vendor;
	   }
}
