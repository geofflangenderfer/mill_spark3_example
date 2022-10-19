package foo
import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd.RDD
import org.apache.logging.log4j.Level

object Example {
  def main(args: Array[String]): Unit = {
    val spark:SparkSession = SparkSession.builder()
        .master("local[5]")
        .appName("SparkByExamples.com")
        .getOrCreate()

    val sc = spark.sparkContext
    sc.setLogLevel("OFF")

    val rdd:RDD[String] = sc.textFile("foo/src/resources/test.txt")

    println("RDD Parition Count :"+rdd.getNumPartitions)
    val rdd2 = rdd.flatMap(f=>f.split(" "))
      .map(m=>(m,1))

    //ReduceBy transformation
    val rdd5 = rdd2.reduceByKey(_ + _)

    println("RDD Parition Count :"+rdd5.getNumPartitions)
  }
}
