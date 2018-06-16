package driver

import org.apache.spark.rdd.RDD
import scala.collection.immutable.Map
import scala.util.{Failure, Success}

object CountInts {


  def countInts(devices: RDD[(Int)]): Map[Int, Long] = devices.map(d => (d, 1L)).reduceByKey(_ + _ ).collect.toMap



  def main(args: Array[String]): Unit = {

    val ss = SparkOps.sparkSession(SparkOps.defaultSparkConf())
    val sc = ss.sparkContext

//    val data = sc.textFile(dataPath)
    ss.stop()
  }
}