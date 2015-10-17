package e_wallet;

import java.util.List;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.dao.*;
import org.springframework.jdbc.core.JdbcTemplate;
 
/**
 *
 * @author Sam
 */
public class Database {
        String SQL;
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	int currentBalance;
	
    /**
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
        
    /**
     *
     * @param fromID
     * @param amount
     * @param start
     * @param type
     * @return
     */
    public int createLog(String fromID, double amount, Date start, int type){
		SQL = "insert into Transactions (fromID, amount, start, type) values (?, ?, ?, ?)";
                jdbcTemplateObject.update( SQL, fromID, amount, start.toString(), type);
                Transactions transaction=null;
		try{ 
		SQL = "select * from transactions where start = ?";
                transaction = jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{start.toString()}, new TransactionsMapper());
                }catch(EmptyResultDataAccessException e){
	    	 
                }
	    return transaction.id; 
	}
        
    /**
     *
     * @param id
     */
    public void deleteLog(int id){
                SQL = "delete from transactions where id = ?";
                jdbcTemplateObject.update(SQL, id);
	      
	}
        
    /**
     *
     * @param id
     * @param to
     * @param end
     * @param completion
     */
    public void updateLog(int id, String to, Date end, int completion){
                SQL = "update transactions set toID = ?, end = ?, completion = ? where id = ?";
                jdbcTemplateObject.update(SQL, to, end.toString(), completion, id);
        }
        
    /**
     *
     * @param id
     * @param comments
     * @param end
     * @param balance
     */
    public void updateLog(int id, String comments, Date end, double balance){
                SQL = "update transactions set comments = ?, end = ?, balance = ? where id = ?";
                jdbcTemplateObject.update(SQL, comments, end.toString(), balance, id);
        }
	
    /**
     *
     * @param name
     * @param uname
     * @param password
     * @return
     */
    public String create(String name, String uname, String password) {
	    if(!verifyIDExists(2,uname)){  
		SQL = "insert into vendor (name, uname, password) values (?, ?, ?)";
                jdbcTemplateObject.update( SQL, name, uname, Controller.toHash(password));
                return ("Created Record Name = " + name + " User Name = " + uname);
            }
            return null;
	}
	
    /**
     *
     * @param name
     * @param bits_id
     * @param password
     * @param pin
     * @return
     */
    public String create(String name, String bits_id, String password, int pin) {
            if(!verifyIDExists(1,bits_id)){    
                SQL = "insert into student (name, bits_id, password, pin) values (?, ?, ?, ?)";
                jdbcTemplateObject.update( SQL, name, bits_id, Controller.toHash(password), pin);
                return ("Created Record Name = " + name + " BITS ID = " + bits_id);
            }
            return null;
	}
	 
    /**
     *
     * @param i
     * @param lcred
     * @return
     */
    public String delete(int i,String lcred){
                if(i==1)
                    SQL = "delete from student where bits_id = ?";
                else
                    SQL = "delete from vendor where uname = ?";
                    
                jdbcTemplateObject.update(SQL, lcred);
                return ("Deleted Record with ID = " + lcred );
	}
	 
    /**
     *
     * @param bits_id
     * @return
     */
    public Student getStudent(String bits_id) {
		 Student student=null;
		 try{ 
                    SQL = "select * from Student where bits_id = ?";
                    student = jdbcTemplateObject.queryForObject(SQL, 
	            new Object[]{bits_id}, new StudentMapper());
	   
                }catch(EmptyResultDataAccessException e){
	    	 
                }
                return student; 
	     
	}
	 
    /**
     *
     * @param uname
     * @return
     */
    public Vendor getVendor(String uname) {
		Vendor vendor=null;
		try{ 
		SQL = "select * from Vendor where uname = ?";
                vendor = jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{uname}, new VendorMapper());
                }catch(EmptyResultDataAccessException e){
	    	 
                }
	     
	    return vendor; 
	     
	}
        
    /**
     *
     * @param lcred
     * @return
     */
        public List<Transactions> findAllEntries(String lcred) {
                return jdbcTemplateObject.query( "SELECT * FROM transactions WHERE fromID = ? ORDER BY end DESC",new Object[]{lcred}, new TransactionsMapper());
        }
        
    /**
     *
     * @param lcred
     * @return
     */
    public List<Transactions> last5Transactions(String lcred) {
                return jdbcTemplateObject.query( "SELECT * FROM transactions WHERE fromID = ? ORDER BY end DESC LIMIT 5",new Object[]{lcred}, new TransactionsMapper());
        }       
	
        
    /**
     *
     * @param uname
     * @param ewbalance
     * @return
     */
	public String updateBalance(String uname, double ewbalance){
	      SQL = "update Vendor set ewbalance = ? where uname = ?";
	      jdbcTemplateObject.update(SQL, ewbalance, uname);
	      return ("Transferred amount. Check Balance ");
	}
	  
	  //For the Student

    /**
     *
     * @param bits_id
     * @param ewbalance
     * @param swdbalance
     * @return
     */
            public String updateBalance(String bits_id, double ewbalance, double swdbalance){
	      SQL = "update Student set ewbalance = ?, swdbalance = ? where bits_id = ?";
	      jdbcTemplateObject.update(SQL, ewbalance, swdbalance, bits_id);
	      return ("The new E-Wallet Balance for "+bits_id+" is Rs."+ewbalance+"\nReturning back to the main menu.\n");
	      
            }
	  
	  //For the Student in case of Credit.

    /**
     *
     * @param bits_id
     * @param ewbalance
     * @param swdbalance
     * @param credit_avail
     * @return
     */
        public String updateBalance(String bits_id, double ewbalance, double swdbalance, double credit_avail){
	      SQL = "update Student set ewbalance = ?, swdbalance = ?, credit_avail = ? where bits_id = ?";
	      jdbcTemplateObject.update(SQL, ewbalance, swdbalance, credit_avail, bits_id);
	      return ("The new E-Wallet Balance for "+bits_id+" is Rs."+ewbalance+"\nReturning back to the main menu.\n");
            }
                
        public String updatelb(String bits_id, int lb){
	      SQL = "update Student set lb = ? where bits_id = ?";
	      jdbcTemplateObject.update(SQL, lb, bits_id);
	      return ("Loyalty Benefits Availed. Check Balance");
	      
            }
	 
    /**
     *
     * @param i
     * @param lcred
     * @return
     */
    public boolean verifyIDExists(int i,String lcred){
		boolean result=true;
		try{ 
			if(i==1){
				SQL = "select * from Student where bits_id = ?";
				Student student = jdbcTemplateObject.queryForObject(SQL, 
                                new Object[]{lcred}, new StudentMapper());
			}
			else{
				SQL = "select * from vendor where uname = ?";
				Vendor vendor = jdbcTemplateObject.queryForObject(SQL, 
		                        new Object[]{lcred}, new VendorMapper());
			}
		   
		     }catch(EmptyResultDataAccessException e){
		    	 result=false;
		     }
		     
		    return result; 
		     
	}

    /**
     *
     * @param student
     * @param password
     * @return
     */
    public boolean verifyPassword(Student student,String password){
            return password.equals(student.password);
	}
	
    /**
     *
     * @param vendor
     * @param password
     * @return
     */
    public boolean verifyPassword(Vendor vendor,String password){
            return password.equals(vendor.password);
	}
	
    /**
     *
     * @param student
     * @param pin
     * @return
     */
    public boolean verifyPIN(Student student,int pin){
            return student.pin==pin;
	}
	
    /**
     *
     * @param bits_id
     * @return
     */
    public double checkBalance(String bits_id){
		Student student = getStudent(bits_id);
		return student.ewbalance;
	}
	
    /**
     *
     * @param uname
     * @return
     */
    public double checkBalanceVendor(String uname){
		Vendor vendor = getVendor(uname);
		return vendor.ewbalance;
	}
}
