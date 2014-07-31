package algorithms.sort

import org.hamcrest.Matchers._
import org.junit.Assert._
import org.junit.Test
import scala.util.Random

class SortTest {

  private val ascend = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  private val descend = Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)

  @Test
  def selection {
    val s = new SelectionSort[Int]
    test(s, ascend)
    test(s, descend)
    for (_ <- 1 to 10) test(s, randomArray(10))
  }

  @Test
  def insertion {
    val s = new InsertionSort[Int]
    test(s, ascend)
    test(s, descend)
    for (_ <- 1 to 10) test(s, randomArray(10))
  }

  @Test
  def shell {
    val s = new ShellSort[Int]
    test(s, ascend)
    test(s, descend)
    for (_ <- 1 to 10) test(s, randomArray(10))
  }

  private def test[T <% Ordered[T]](s: Sort[T], a: Array[T]) {
    val input = a.mkString(" ")
    s.sort(a)
    assertThat(
      "'%s' -> '%s'".format(input, a.mkString(" ")),
      isSorted(a), is(true))
  }

  private def isSorted[T <% Ordered[T]](a: Array[T]): Boolean = {
    for (i <- 1 to a.length - 1)
      if (a(i) < a(i - 1)) return false
    true
  }

  private def randomArray(n: Int) = (0 to n - 1).foldLeft(new Array[Int](n)) {
    (a, i) => a(i) = Random.nextInt(10); a
  }

}
