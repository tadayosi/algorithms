package algorithms.data

import org.hamcrest.Matchers._
import org.junit.Assert._
import org.junit.Test

class PriorityQueueTest {

  @Test
  def insert_deleteMax {
    val pq = new PriorityQueue[Int](3)
    pq.insert(2)
      .insert(1)
      .insert(3)
    assertThat(pq.deleteMax.get, is(3))
    assertThat(pq.deleteMax.get, is(2))
    pq.insert(0)
    assertThat(pq.deleteMax.get, is(1))
    assertThat(pq.deleteMax.get, is(0))
    assertThat(pq.deleteMax, is(None: Option[Int]))
  }

  @Test
  def insert_capacity {
    val pq = new PriorityQueue[Int](3)
    pq.insert(1)
      .insert(2)
      .insert(3)
      .insert(4)
      .insert(5)
  }

  @Test
  def deleteMax_empty {
    val pq = new PriorityQueue[Int](3)
    assertThat(pq.deleteMax, is(None: Option[Int]))
    assertThat(pq.deleteMax, is(None: Option[Int]))
    assertThat(pq.deleteMax, is(None: Option[Int]))
  }

}
