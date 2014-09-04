package algorithms.string.data

import scala.math._

class SuffixArray(str: String) {

  val index: Seq[Int] = sortIndexes(str)

  private def sortIndexes(s: String) = {
    def comparator(i: Int, j: Int): Boolean = {
      for (k <- 0 until s.length - max(i, j)) {
        if (s.charAt(i + k) < s.charAt(j + k)) return true
        if (s.charAt(i + k) > s.charAt(j + k)) return false
      }
      i > j
    }
    (0 until s.length).sortWith(comparator)
  }

  def length: Int = str.length

  def select(i: Int): String = str.substring(index(i))

  /** Longest common prefix */
  def lcp(i: Int): Int =
    if (i == 0) 0
    else {
      val n = length - max(index(i - 1), index(i))
      for (j <- 0 until n)
        if (str.charAt(index(i - 1) + j) != str.charAt(index(i) + j))
          return j
      n
    }

}
