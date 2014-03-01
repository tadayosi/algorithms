package algorithms.sort

class SelectionSort[T <% Ordered[T]] extends Sort[T] {

    def sort(a: Array[T]) {
        for (i <- 0 to a.length - 1) {
            var min = i
            for (j <- i + 1 to a.length - 1)
                if (less(a(j), a(min))) min = j
            exchange(a, i, min)
        }
    }

}