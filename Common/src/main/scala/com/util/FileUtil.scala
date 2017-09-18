package com.util



import reflect.io
import java.io.File

object FileUtil  {
  //Main 
  def main(args: Array[String]): Unit = {
    
  // Different types of file extensions
  val file_Extension=List("ctl","meta","docx")
  //File Directory Path
  val dir:String = "C:/Users/suresh/Desktop/ListDir/Meta"
  //Method
  def getListofFiles(dir: String,extension:List[String]):List[File] = {
     
   //Empty directory
 val d = new File(dir)
 //Required File Extension
 val endString ="docx"
  // File Filtering of given File extension
 if (d.exists && d.isDirectory) {
        d.listFiles.filter(_.isFile).toList.filter { file => file_Extension.exists(file.getName.endsWith(_))}
    } else {
        List[File]()
    }
}
//Call the Method
  val files = getListofFiles(dir, file_Extension)
files.foreach(println)
 
}
}
