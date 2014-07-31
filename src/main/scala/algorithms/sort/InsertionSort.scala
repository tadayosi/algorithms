package algorithms.sort

class InsertionSort[T <% Ordered[T]] extends Sort[T] {

  def sort(a: Array[T]) {
    val n = a.length
    for (i <- 1 to n - 1) insert(a, i)
  }

  private def insert(a: Array[T], i: Int) {
    for (j <- i to 1 by -1 if less(a(j), a(j - 1)))
      exchange(a, j, j - 1)
  }

}
