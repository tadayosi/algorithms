package algorithms.sort

/**
 * Least Significant Digit radix sort
 */
class LSD(length: Int) extends Sort[String] {

  val radix = 256

  def sort(a: Array[String]) {
    val n = a.length
    val temp = new Array[String](n)
    for (d <- length - 1 to 0 by -1) {
      val count = new Array[Int](radix + 1)
      for (i <- 0 until n)
        count(a(i).charAt(d) + 1) += 1
      for (r <- 0 until radix)
        count(r + 1) += count(r)
      for (i <- 0 until n) {
        temp(count(a(i).charAt(d))) = a(i)
        count(a(i).charAt(d)) += 1
      }
      Array.copy(temp, 0, a, 0, n)
    }
  }

}
