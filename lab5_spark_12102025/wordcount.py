import pyspark
from pyspark.sql import SparkSession

spark = SparkSession.builder.master("local[*]").appName('wordcount').getOrCreate()
data = spark.sparkContext.textFile("hdfs://hadoop-master:9000/user/root/input/alice.txt")
words = data.flatMap(lambda line: line.split(" "))
wordCounts = words.map(lambda word: (word, 1)).reduceByKey(lambda a,b:a + b)
wordCounts.saveAsTextFile("hdfs://hadoop-master:9000/user/root/output/rr2")
