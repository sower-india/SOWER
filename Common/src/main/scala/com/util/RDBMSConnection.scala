
import java.sql.DriverManager
import java.sql.Connection
import com.util.PropertyReader
import com.util.CommonConstants
import java.sql.ResultSet

object RDBMSConnection {
  
  
  def getConnection():Connection ={
    
    val reader:PropertyReader  = new PropertyReader();
    val userName:String = reader.getProperty(CommonConstants.USERNAME);
    ???
    
  }
  
  def readData(sqlQuery:String):ResultSet ={
    ???
  }

  def main(args: Array[String]): Unit = {

    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/sower"
    val username = "root"
    val password = "root"

    var connection: Connection = null

    Class.forName(driver)
    println("hi1")
    connection = DriverManager.getConnection(url, username, password)
    println("hi")
    val statement = connection.createStatement()
    val resultset = statement.executeUpdate("create table trns(custid int Primary key,name varchar(20),pancard Int unique)")


    connection.close()

  }

}