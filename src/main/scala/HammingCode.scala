
object HammingCode extends App {
  //Jana Fedotova, jp12055
  //Prograamu, kas nokode bitu ar Hamminga kodu
  //
  def calculatingRedundantBits(m:Int):Int ={
    //Izmantojam formulu 2^r>= m+r+1
    //Iretejam cauri no 0 līdz m un atgriežam rezultātu kas apmierina vienādojumu
    var res = 0
    while (Math.pow(2,res) < (m + res +1)){
      res += 1
    }
    res
  }
  //Funkcija, kura nosaka redundant bitu pozīcijas un tajās ievieto 0
  def position(data: String, r:Int): String ={
    val reverseData = data.reverse
    var res = ""
    var k = 0
    var j = 0
    var i = 1
    while (i < data.length+r+1){
      //Ivietojām pozīcijās kur 2^i
      if (Math.pow(2,j).toInt == i){
        res = res + '0'
        j += 1
      } else {
        res = res + reverseData(k)
        k += 1
      }
      i += 1
    }
    res
  }
  //Funkcija, kura aprēķina r bitu vērtības katrai pozīcijas 2^i
  def calculation(data: String, r: Int): Unit ={
  val dataOfIntegers = data.split("").map(_.toInt)
    //Katram reduntan bitam rēķināsim vērtību
    for (i <- 0 until r){
      val step = Math.pow(2,i).toInt //solis kuram pārbaudīsim vērtību
      val notCheckedBits = step*2 //Solis lai palaistu garām tos bitu kurus nepārbaudīsim
      var start = step //sākuma pozīcija no kuras pārbaudīsim
      var positionCheck = start
      //println()
//      println("Calculating Parity bit for Position: " + step)
//      print("Bits to be checked: ")
      var pos = 0 //Ar šo mainīgo pārbaudīsim vai pārbaudītu bitu summa it pāra vai nepāra
      //Uzrakstam tos bitus kurus pārbaudīsim
      while (start <= dataOfIntegers.length){
        for (k <- start until start + step) {
          if (k <= dataOfIntegers.length){
          //print(k+" ")
          positionCheck=k
            //šeit tiek pārbaudīti vai pārbaudītu bitu summa ir pāra vai nepāra
          pos = pos + dataOfIntegers(k-1)
            if (pos % 2 == 0){
            dataOfIntegers(step-1) = 0
            } else {dataOfIntegers(step-1) = 1}
          }
        }
        start=start+notCheckedBits
      }
    }
    //println()
    println("Coded message is: ")
    dataOfIntegers.foreach(print)
    println()
  }

  val check = "01110"
  val m = check.length
  val r = calculatingRedundantBits(m)
  println("Number of parity bits needed:" + r)
  val res = position(check,r)
  calculation(res,r)

  val check2 = "01010101"
  println("Number of parity bits needed:" + calculatingRedundantBits(check2.length))
  val res2 = position(check2,calculatingRedundantBits(check2.length))
  calculation(res2,calculatingRedundantBits(check2.length))

  val check3 = "11100010"
  println("Number of parity bits needed:" + calculatingRedundantBits(check3.length))
  val res3 = position(check3,calculatingRedundantBits(check3.length))
  calculation(res3,calculatingRedundantBits(check3.length))

  val check4 = "00011011"
  println("Number of parity bits needed:" + calculatingRedundantBits(check4.length))
  val res4 = position(check4,calculatingRedundantBits(check4.length))
  calculation(res4,calculatingRedundantBits(check4.length))

  val check5 = "0110"
  println("Number of parity bits needed:" + calculatingRedundantBits(check5.length))
  val res5 = position(check5,calculatingRedundantBits(check5.length))
  calculation(res5,calculatingRedundantBits(check5.length))




}
