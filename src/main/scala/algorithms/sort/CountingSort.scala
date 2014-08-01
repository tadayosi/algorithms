package algorithms.sort

class CountingSort(radix: Int) extends Sort[Int] {

  def sort(a: Array[Int]) {
    val count = new Array[Int](radix)
    val n = a.length

    for (i <- 0 until n)
      count(a(i)) += 1

    var i = 0
    for (r <- 0 until radix)
      while (count(r) > 0) {
        a(i) = r
        i += 1
        count(r) -= 1
      }
  }

}