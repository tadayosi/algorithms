package algorithms.string

import org.hamcrest.Matchers._
import org.junit.Assert._
import org.junit.Test
import algorithms.string.data.SuffixArray

class StringTest {

  @Test
  def suffixArray {
    val str = "it was the best of times it was the"
    val sa = new SuffixArray(str)
    assertThat(sa.length, is(str.length))
    assertThat(sa.index(9), is(4))
    assertThat(sa.select(9), is("as the best of times it was the"))
    assertThat(sa.lcp(20), is(10))
  }

  @Test
  def lrs {
    val str = "it was the best of times it was the"
    val lrs = new LongestRepeatedSubstring
    assertThat(lrs(str), is("it was the"))
  }

}
