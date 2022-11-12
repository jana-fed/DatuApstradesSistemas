import com.redis.RedisClient


object MD1_Redis extends App {
  //Jana Fedotova jp12055
  //1. mājas darbs Datu apstrādes sistēmās
  //Izmantoju Scala programēšanas valodas bibliotēku
  // https://mvnrepository.com/artifact/net.debasishg/redisclient
  //Izveidoju kontu https://app.redislabs.com/#/login un pieslēdzos pie šīs datubāzes
  //Izmantoju port, url un paroli no redis app datubāzes
  val port = 18321
  val url = "redis-18321.c55.eu-central-1-1.ec2.cloud.redislabs.com"
  val dbName = "LU-free-db"
  val pw = Some("gztxFAitRi3Ms1q7BoULhRC48QoNrZKR")
  val csvFilePath = "src/resources/generic-food.csv"

  //Pieslēdzos pie savas redis datubāzes https://app.redislabs.com/#/login
  val r = new RedisClient(host=url, port, 0, secret= pw)

//  //Ielādējam datus no csv faila generic-food.csv
//  val bufferedSource = io.Source.fromFile(csvFilePath)
//  val data = bufferedSource.getLines.map(_.split(",")).drop(1).toArray
//
//  //Pārbaudam masīva elemantus
//  //data.take(5).foreach(line => println(line.mkString("|")))
//  bufferedSource.close
//
//  //Pārbaudu ierakstu skaitu
//  println(s"Ierakstu skaits: ${data.length}")
//
//  //Ielādejam datus redis datubāzē.
//  var index = 0;
//  while (index < data.length){
//    r.hmset(s"$index", Array(("foodName", data(index)(0)),
//          ("scientificName", data(index)(1)),
//          ("group", data(index)(2)),
//          ("subGroup", data(index)(3))
//        ))
//    index += 1
//        }
//
//  //Pārbaudam vienu ierakstu
//  println(r.hmget("5","foodName","scientificName","group","subGroup").getOrElse(" "))
//
//  //Mainam vairākus ierakstus
//  //Mainam foodName
//  for (i <-  5 to 20) {
//    r.hset(s"$i", "foodName", "changed by Jana")
//    println(r.hmget(s"$i", "foodName", "scientificName", "group", "subGroup").getOrElse(" "))
//  }
//  //Mainam atslēgu vērtibu
//  for (i <- 5 to 20){
//    r.rename(s"$i",s"record $i")
//    println(r.hmget(s"record $i", "foodName", "scientificName", "group", "subGroup").getOrElse(" "))
//  }
//
//  //Atlasam ierakstus
//  for (i <- 21 to 50){
//    println(r.hmget(s"$i", "foodName", "scientificName", "group", "subGroup").getOrElse(" "))
//  }
//
//  //Dzēšam ierakstus
//  for (i <- 5 to 20){
//    r.del(s"$i")
//    println(r.hmget(s"$i", "foodName", "scientificName", "group", "subGroup").getOrElse(" "))
//  }
//
//  //Istīram datubāzi
//  //r.flushdb
//  r.close()
}
