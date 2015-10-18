package e_wallet;

import java.sql.*;

public class TableSetup {
 // JDBC driver name and database URL 


 //  Database credentials
 
 
 public static void main(String[] args) {
 Connection conn = null;
 Statement stmt = null;
 try{
    //STEP 2: Register JDBC driver
    Class.forName(CreateDatabase.JDBC_DRIVER);

    //STEP 3: Open a connection
    System.out.println("Connecting to the e_wallet database...");
    conn = DriverManager.getConnection(CreateDatabase.DB_URL,"root",""); //, CreateDatabase.USER, CreateDatabase.PASS);
    System.out.println("Connected database successfully...");
    
    //STEP 4: Execute a query
    System.out.println("Creating table in given database...");
    stmt = conn.createStatement();
    
    String sql = "CREATE TABLE IF NOT EXISTS Student(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50) NOT NULL, bits_id VARCHAR(50), password VARCHAR(50), pin INT, ewbalance INT, credit_avail INT, swdbalance INT)";
    stmt.executeUpdate(sql);
    System.out.println("Created Student table in given database...");

    String sql1 = "CREATE TABLE IF NOT EXISTS Vendor(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50) NOT NULL,_name VARCHAR(50), password VARCHAR(50), ewbalance INT)";
	stmt.executeUpdate(sql1);
    System.out.println("Created Vendor table in given database...");

    String sql2 = "CREATE TABLE IF NOT EXISTS Transactions(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, fromID VARCHAR(50) NOT NULL,toID VARCHAR(50))";
	stmt.executeUpdate(sql2);
    System.out.println("Created Transaction table in given database...");
    
 }catch(SQLException se){
    //Handle errors for JDBC
    se.printStackTrace();
 }catch(Exception e){
    //Handle errors for Class.forName
    e.printStackTrace();
 }finally{
    //finally block used to close resources
    try{
       if(stmt!=null)
          conn.close();
    }catch(SQLException se){
    }// do nothing
    try{
       if(conn!=null)
          conn.close();
    }catch(SQLException se){
       se.printStackTrace();
    }//end finally try
 }//end try
// System.out.println("Goodbye!");
}//end main
}//end