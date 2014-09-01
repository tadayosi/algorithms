package algorithms.sort

import org.hamcrest.Matchers._
import org.junit.Assert._
import org.junit.Test
import scala.util.Random
import org.junit.Ignore
import scala.reflect.ClassTag

class SortTest {

  private val ascend = array(10)(i => i)
  private val descend = array(10)(i => 9 - i)

  @Test
  def selection {
    val s = new SelectionSort[Int]
    test(s, ascend)
    test(s, descend)
    for (_ <- 1 to 10) test(s, randomDigits(10))
  }

  @Test
  def insertion {
    val s = new InsertionSort[Int]
    test(s, ascend)
    test(s, descend)
    for (_ <- 1 to 10) test(s, randomDigits(10))
  }

  @Test
  def shell {
    val s = new ShellSort[Int]
    test(s, ascend)
    test(s, descend)
    for (_ <- 1 to 10) test(s, randomDigits(10))
  }

  @Test
  def counting {
    val s = new CountingSort(10)
    test(s, ascend)
    test(s, descend)
    for (_ <- 1 to 10) test(s, randomDigits(10))
  }

  @Test
  def lsd {
    val s = new LSD(10)
    def randomStrings = array(10)(_ => Random.alphanumeric.take(10).mkString)
    for (_ <- 1 to 10) test(s, randomStrings)
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
      if (a(i - 1) > a(i)) {
        println(i + ": " + a(i - 1) + " > " + a(i))
        return false
      }
    true
  }

  private def randomDigits(n: Int): Array[Int] =
    array(n)(_ => Random.nextInt(10))

  private def array[T: ClassTag](n: Int)(f: Int => T): Array[T] =
    (0 until n).map(f).toArray

}
