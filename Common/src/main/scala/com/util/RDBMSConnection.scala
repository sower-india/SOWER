package com.util;
import java.sql.DriverManager
import java.sql.Connection
import com.util.PropertyReader
import com.util.CommonConstants
import java.sql.ResultSet
import java.sql.Statement
import java.sql.PreparedStatement

object RDBMSConnection {
  
  
  def getConnection():Connection ={
    
    val reader:PropertyReader  = new PropertyReader();
    val userName:String = reader.getProperty(CommonConstants.USERNAME);
    
    val url:String = reader.getProperty(CommonConstants.URL);
    val password:String = reader.getProperty(CommonConstants.PASSWORD);
    val driver:String = reader.getProperty(CommonConstants.DRIVER);
    var connection: Connection = null

    Class.forName(driver)
    DriverManager.getConnection(url, userName, password);
  }
  
  
  def readData(sqlQuery:String):ResultSet ={
    val connection:Connection=getConnection();
    
    val statement:Statement = connection.createStatement();
    val results=statement.executeQuery(sqlQuery);
    if(connection!=null)
    {
      connection.close();
    }
    
    results;
    
  }
  
  def populateData():Boolean={
  
    
    val insertAddressQuery:String = "insert into suresh(customer,transaction,order_name) values (?,?,?)"; 
    val connection:Connection = getConnection();
    val statement:PreparedStatement=connection.prepareStatement(insertAddressQuery);
    statement.setString(1, "TESTC");
    statement.setString(2, "TEST");
    statement.setString(3, "TEST");
    val inserted=statement.execute();
     if(connection!=null)
    {
      connection.close();
    }
    
    inserted;
    
  }

  def main(args: Array[String]): Unit = {

   populateData();
  }

}