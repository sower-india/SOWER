package com.sower.datagenerator

trait DataGenerator {
  def parseFile(inputFile:String):Map[String, DataGenerator];
  
}