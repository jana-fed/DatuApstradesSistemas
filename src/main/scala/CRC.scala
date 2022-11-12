object CRC extends App {
  //Jana Fedotova, jp12055
  //Programma pārbauda vai ienākošos datos ir klūda
  //Piemeŗs
  val data = "101101"
  //atslēga
  val CRCGenerator = "1101"
  println("CRC Generator: " + CRCGenerator)
  val encodedData = "101101101"
  dataEncode(data,CRCGenerator)
  errorCheck(encodedData,CRCGenerator)


  //XoR funkcija, kas piešķir 1 vai 0 vērtību. Ir nepiecišama tālākajai daļīšanai
  def xor(a:String,b:String): String ={
    var result = ""
    val n = b.length
    for (i <- 1 until n ){
      if (a(i) == b(i)){
        result += "0"
      } else {
        result += "1"
      }
    }
    result
  }
  //Funkcija kas dala datus ar atslēgu
  def mod2division(data:String, divisor:String): String ={
    var p = divisor.length
    var t = data.substring(0, p)
    val n = data.length
    //kamēr dalītāja garums ir mazāks nekā datu garums cikls darbojās
    while (p < n){
      if (t(0).equals('1')){
        t = xor(data,t) + data(p)
      } else {
        var s = ""
        for (i <- 0 until p){
          s = s.concat("0")
        }
        t = xor(s,t) + data(p)
      }
      p += 1
    }
    if (t(0).equals('1')){
      t = xor(divisor,t)
    } else {
      val m = (p*'0').toString
      t = xor(m,t)
    }
    t //iegūts atlikums
  }

    //Funckija kas pie datiem pieskaita nulles
  def dataEncode(data:String, CRCGenerator: String): Unit ={
    val l = CRCGenerator.length
    val dataWithZeros = data + "0"*(l-1)
    println(dataWithZeros)
    val remainder = mod2division(dataWithZeros,CRCGenerator)
    val sendCode = data + remainder
    println("Remainder: " + remainder)
    println("Encoded Data: " + sendCode)

  }
  //Funkcija kas pārbauda vai dati ir korekti
  def errorCheck(data:String,CRCGenerator:String): Unit ={
    val remainder = mod2division(data,CRCGenerator)
    println("Checking errors in received data!")
    println("Received data is: " + data)
    println("Received key is: " + CRCGenerator)
    if (remainder.contains("1")){
      println("Received data is corrupted!")
    } else {
      println("Received data is correct!")
    }
  }


}
