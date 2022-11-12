object HammingEncoding extends App {

  //Jana Fedotova, jp12055
//Programma kas atrod kļūdu iegūtā bitā
  def calculatingRedundantBits(m:Int):Int ={
    //Izmantojam formulu 2^r>= m+r+1
    //Iretejam cauri no 0 līdz m un atgriežam rezultātu kas apmierina vienādojumu
    var res = 0
    while (Math.pow(2,res) < (m +1)){
      res += 1
    }
    res
  }
  //Funkcija, kura aprēķina r bitu vērtības katrai pozīcijas 2^i
  def calculation(data: String, r: Int): Unit ={
    val dataOfIntegers = data.split("").map(_.toInt)
    var bitCode = ""
    for (i <- 0 until r){
      val step = Math.pow(2,i).toInt//solis kuram pārbaudīsim vērtību
      val notCheckedBits = step*2 //Solis lai palaistu garām tos bitu kurus nepārbaudīsim
      var start = step //sākuma pozīcija no kuras pārbaudīsim
      var positionCheck = start
//      println()
//      println("Calculating Parity bit for Position: " + step)
//      print("Bits to be checked: ")
      var pos = 0//Ar šo mainīgo pārbaudīsim vai pārbaudītu bitu summa it pāra vai nepāra
      //Uzrakstam tos bitus kurus pārbaudīsim
      while (start <= dataOfIntegers.length){
        for (k <- start until start + step) {
          if (k <= dataOfIntegers.length){
            //print(k+" ")
            positionCheck=k
            pos = pos + dataOfIntegers(k-1)
          }
        }
        start=start+notCheckedBits
      }
      //šeit tiek pārbaudīti vai pārbaudītu bitu summa ir pāra vai nepāra
      //Ja bitu summa ir pāra skaitlis tad pārbaudes bitam tiek piešķirta vērtība 0, ja otrādi tad 1
      if (pos % 2 == 0){
        bitCode += "0"
      } else {bitCode += "1"}
    }
    val res = bitCode.reverse
    //iegūto bita kodu pārveidojam cipara un nosakam kurā pozīcijā ir kļūda
    val result = Integer.parseInt(res, 2)
    println()
    //println(res)
    println("Received data is: ")
    dataOfIntegers.foreach(print)
    println()
    if (result == 0 ){
      println("No bits are corrupted")
    } else {
    println("Data is corruptes in position: ")
    println(result)
    //Izlabojam datus bitCode pozīcijā
    var correctedCode = correction(data,result)
    println()
    println("Corrected data is: ")
    correctedCode.foreach(print)}

  }
  //Funkcija kas izlabo bitu iedotā pozīcijā
  def correction(str: String, errorPos: Int): Array[Int] ={
    var dataOfIntegers = str.split("").map(_.toInt)
    if (dataOfIntegers(errorPos-1) == 1){
      dataOfIntegers(errorPos-1) = 0
    } else {
      dataOfIntegers(errorPos-1) = 1
    }
    dataOfIntegers
  }
  //Piemēri, nemti no HammingCode programmas generācijas
  //Dažos ir pamainīti biti
  val check = "000111101"
  val m = check.length
  val r = calculatingRedundantBits(m)
  calculation(check,r)
  println()

  val check2 = "111101001000"
  val r2 = calculatingRedundantBits(check2.length)
  calculation(check2, r2)
  val check3 = "000010010111"
  val r3 = calculatingRedundantBits(check2.length)
  calculation(check3, r3)

  val check4 = "001010111001"
  val r4 = calculatingRedundantBits(check2.length)
  calculation(check4, r4)

  val check5 = "1100110"
  val r5 = calculatingRedundantBits(check2.length)
  calculation(check5, r5)

}
