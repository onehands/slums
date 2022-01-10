import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkDataframeTest {
//  val sparkConf = new SparkConf().setMaster("local")
//  sparkConf.set("spark.testing.memory", "2147480000")
//  val spark = SparkSession.builder.config(conf = sparkConf).getOrCreate()

  def main(args: Array[String]): Unit = {
//    spark.sql("drop table spark_cred_r_data_mongo.inv_hive_parquet")
//    spark.sql("CREATE TABLE spark_cred_r_data_mongo.inv_hive_parquet(      trans_id int)   PARTITIONED BY (          year int)   STORED AS PARQUET   TBLPROPERTIES ('PARQUET.COMPRESSION'='SNAPPY')")
//    val df = spark.createDataFrame(Seq(
//      (20, 2021)
//    )) toDF("trans_id", "year")
//    df.show()
//    df.write.format("hive").partitionBy("pt").mode("append").option("compression","snappy").saveAsTable("spark_cred_r_data_mongo.inv_hive_parquet")
//

    println("$".startsWith("$"))
  }

}
