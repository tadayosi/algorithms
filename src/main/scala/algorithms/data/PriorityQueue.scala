package algorithms.data

class PriorityQueue[T <% Ordered[T]](initialCapacity: Int) {

  private var queue: Array[Option[T]] = Array.fill(initialCapacity + 1)(None)
  private var length: Int = 0

  def isEmpty: Boolean = length == 0

  def insert(e: T): PriorityQueue[T] = {
    if (length == queue.length - 1)
      resize(2 * queue.length)
    length += 1
    queue(length) = Some(e)
    swim(length)
    this
  }

  def deleteMax: Option[T] =
    if (isEmpty) None
    else {
      val max = queue(1)
      exchange(1, length)
      queue(length) = None
      length -= 1
      sink(1)
      if (length == queue.length / 4
        && queue.length / 2 >= initialCapacity + 1)
        resize(queue.length / 2)
      max
    }

  private def resize(capacity: Int) {
    val newQueue: Array[Option[T]] = Array.fill(capacity)(None)
    Array.copy(queue, 1, newQueue, 1, length)
    queue = newQueue
  }

  private def swim(i: Int) {
    @annotation.tailrec
    def loop(i: Int) {
      if (i <= 1) return
      val up = i / 2
      if (!less(up, i)) return
      exchange(up, i)
      loop(up)
    }
    loop(i)
  }

  private def sink(i: Int) {
    @annotation.tailrec
    def loop(i: Int) {
      val j = 2 * i
      if (j > length) return
      val down = if (j < length && less(j, j + 1)) j + 1 else j
      if (!less(i, down)) return
      exchange(i, down)
      loop(down)
    }
    loop(i)
  }

  private def less(i: Int, j: Int): Boolean = queue(i).get < queue(j).get

  private def exchange(i: Int, j: Int) {
    val tmp = queue(i)
    queue(i) = queue(j)
    queue(j) = tmp
  }

}
