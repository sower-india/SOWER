package com.util

import scala.io.Source
import java.util.Properties
import java.io.FileInputStream

/**
 * This is created by suresh
 * 
 * create method : loadProperties(String fileName): Map<String,String>
 * getProperty(String)
 * 
 * common.properties
 * key1=value1
 * SOWER_DATEFORMAT_PATTER=yyyy-mm-DD
 */
class PropertyReader {
  
  var propertyFileName:String=null;
  
  def PropertyReader(inputFileName:String):Unit =
  {
    propertyFileName = inputFileName;
  }
  
  val fileName = "C:/Users/suresh/git/SOWER/Common/src/main/resources/jdbc.properties";
  
  var properties:Map[String,String] = Map();
  
  private def loadProperties(fileName:String):Unit=
  {
   
//    val iter:Iterator[String] = Source.fromFile(fileName).getLines();
    
    val lproperties:Properties = new Properties();
    lproperties.load(new FileInputStream(fileName));
//    lproperties.forEach()
    lproperties.stringPropertyNames().forEach(name =>  
      {
        properties += name -> lproperties.getProperty(name);
      
      }
    )
  }
  
  def getProperty(key:String): String =
  {
   if(properties==null || properties.isEmpty)
   {
     if(propertyFileName==null){
      loadProperties(); 
     }else{
       loadProperties(propertyFileName);
     }
     
   }
     properties(key);
   
  }
  
  private def loadProperties():Unit ={
    loadProperties(fileName);
  }
  
}