package driver

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

import scala.io.Source


class BaseSpecDriver(sc: SparkContext) {


s
  def testdata():RDD[String] = sc.parallelize(Source.fromURL(getClass.getResource("sample.json")).getLines().toList)



}
