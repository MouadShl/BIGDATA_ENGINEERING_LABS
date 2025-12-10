import org.apache.spark.{SparkConf, SparkContext}

object WordCountScala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCountScala").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    val data = sc.textFile("hdfs://hadoop-master:9000/user/root/input/alice.txt")
    val words = data.flatMap(line => line.split(" "))
    val wordCounts = words.map(word => (word, 1)).reduceByKey(_ + _)
    
    wordCounts.saveAsTextFile("hdfs://hadoop-master:9000/user/root/output/spark-scala")
    
    sc.stop()
  }
}
