package algorithms.sort

class ShellSort[T <% Ordered[T]] extends Sort[T] {

    def sort(a: Array[T]) {
        val n = a.length
        hsort(largest(1, n), a, n)
    }

    private def largest(h: Int, n: Int): Int =
        if (h >= n / 3) h
        else largest(3 * h + 1, n)

    private def hsort(h: Int, a: Array[T], n: Int) {
        if (h < 1) return
        for (i <- h to n - 1)
            for (j <- i to h by -h if less(a(j), a(j - h)))
                exchange(a, j, j - h)
        hsort(h / 3, a, n)
    }

}