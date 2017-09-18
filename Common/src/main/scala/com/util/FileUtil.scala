package com.util

import reflect.io
import java.io.File
import scala.io.Source
import java.io.FilenameFilter

object FileUtil  {
  def readLines(fileName:String):List[String] = {
    Source.fromFile(fileName).getLines().toList;    
  }
  
  private def recursiveListFiles(f: File): Array[File] = {
  val these = f.listFiles
  these ++ these.filter(_.isDirectory).flatMap(recursiveListFiles(_))
}
  
  def recursiveListFiles(directoryName: String): Array[String] = {
    
  val input = new File(directoryName);
  
  if(input.isDirectory())
  {
  recursiveListFiles(input).map(f=> f.getAbsolutePath());
  }else{
    ???
  }
  
}
  
  def getListOfFiles(dir: File, extensions: List[String]): List[File] = {
    dir.listFiles.filter(_.isFile).toList.filter { file =>
        extensions.exists(file.getName.endsWith(_))
    }
}
  
  def getListOfFiles(dir: File, extensions: String): List[File] = {
    dir.listFiles.filter(_.isFile).toList.filter { file =>
        file.getName.endsWith(extensions)
    }
}
  
}
