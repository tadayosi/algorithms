package algorithms.sort

class SelectionSort[T <% Ordered[T]] extends ComparisonSort[T] {

  def sort(a: Array[T]) {
    val n = a.length
    for (i <- 0 to n - 1) select(a, n, i)
  }

  private def select(a: Array[T], n: Int, i: Int) {
    var min = i
    for (j <- i + 1 to n - 1 if less(a(j), a(min)))
      min = j
    exchange(a, i, min)
  }

}
