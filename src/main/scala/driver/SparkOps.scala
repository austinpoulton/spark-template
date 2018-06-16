package driver

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import com.typesafe.config.{Config, ConfigFactory}

object SparkOps {

  def txmEnvironment():String = sys.env.get("TXM_SPARK_ENV").getOrElse("LOCAL")

  def environmentConfig():Config = txmEnvironment() match {
    case "PROD" => ConfigFactory.load("application.conf").getConfig("prod")
    case "QA" =>   ConfigFactory.load("application.conf").getConfig("qa")
    case _ => ConfigFactory.load("application.conf")
  }

  def defaultSparkConf():SparkConf = {
    val conf = new SparkConf()
      .setAppName("Device Data Processor")
      .setMaster("local[*]")
      .set("fs.s3a.impl", classOf[org.apache.hadoop.fs.s3a.S3AFileSystem].getName)
      .set("fs.file.impl", classOf[org.apache.hadoop.fs.LocalFileSystem].getName)
      .set("spark.hadoop.fs.s3a.impl", classOf[org.apache.hadoop.fs.s3a.S3AFileSystem].getName)
      .set("spark.hadoop.fs.file.impl", classOf[org.apache.hadoop.fs.LocalFileSystem].getName)
      .set("spark.hadoop.validateOutputSpecs", "false")
      .set("spark.driver.maxResultSize", "10g")
    conf
  }


  def sparkSession(conf: SparkConf):SparkSession = {
    val spark = SparkSession
      .builder()
      .config(conf)
      .getOrCreate()
    spark
  }

}

// Todo maybe a base driver?  Naaah
abstract class BaseDriver(val driverName : String, val jobConfig : Config, val sparkConfig: SparkConf) {

}