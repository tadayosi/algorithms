package algorithms.sort

abstract class Sort[T <% Ordered[T]] {

    def sort(a: Array[T]): Unit

    def less(v1: T, v2: T): Boolean = v1 < v2

    def exchange(a: Array[T], i: Int, j: Int) {
        val tmp = a(i)
        a(i) = a(j)
        a(j) = tmp
    }

}