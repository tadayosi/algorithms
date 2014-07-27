package algorithms.string

class LongestRepeatedSubstring {

  def apply(str: String): String = {
    val sa = new SuffixArray(str.replaceAll("\\s+", " "))
    (0 until sa.length).foldLeft("") { (s, i) =>
      val lcp = sa.lcp(i)
      if (lcp > s.length) sa.select(i).substring(0, lcp) else s
    }
  }

}
