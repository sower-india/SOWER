package com.util



import reflect.io
import java.io.File
import scala.io.Source

object FileUtil  {
  def readLines(fileName:String):List[String] = {
    Source.fromFile(fileName).getLines().toList;    
  }
  
  def readFileAbsoluteNames(directory:String):List[String] = {
    
//    Source.fr
    
    ???
  }
  
  
}
