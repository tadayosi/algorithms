package algorithms.sort

import org.hamcrest.Matchers._
import org.junit.Assert._
import org.junit.Test
import scala.util.Random

class SortTest {

    @Test
    def selection {
        for (_ <- 1 to 10) test(new SelectionSort[Int], array(10))
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

    private def array(n: Int) = (0 to n - 1).foldLeft(new Array[Int](n)) {
        (a, i) => a(i) = Random.nextInt(10); a
    }

}