/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package e_wallet;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sam
 */
public class TransactionsMapper implements RowMapper<Transactions> {
    
    @Override
    public Transactions mapRow(ResultSet rs, int rowNum) throws SQLException {
    Transactions transaction = new Transactions();
    transaction.setId(rs.getInt("id"));
    transaction.setFrom(rs.getString("fromID"));
    transaction.setTo(rs.getString("toID"));
    transaction.setAmount(rs.getDouble("amount"));
    transaction.setStart(rs.getString("start"));
    transaction.setEnd(rs.getString("end"));
    transaction.setType(rs.getInt("type"));
    transaction.setBalance(rs.getDouble("balance"));
    transaction.setComments(rs.getString("comments"));
    transaction.setCompletion(rs.getInt("completion"));
    return transaction;
	   }
}
