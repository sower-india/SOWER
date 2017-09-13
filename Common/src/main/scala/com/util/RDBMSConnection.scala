
import java.sql.DriverManager
import java.sql.Connection

object RDBMSConnection {

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