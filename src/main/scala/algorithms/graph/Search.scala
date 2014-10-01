package algorithms.graph

import algorithms.graph.data.Graph

trait Search {
  def search(s: Int): SearchResult
}

class SearchResult(n: Int) {
  private[graph] val marked: Array[Boolean] = Array.fill(n)(false)
  private[graph] val predecessor: Array[Option[Int]] = Array.fill(n)(None)
  def hasPathTo(v: Int): Boolean = marked(v)
  def pathTo(v: Int): Option[Iterable[Int]] = {
    @annotation.tailrec
    def loop(v: Int, res: List[Int]): List[Int] =
      predecessor(v) match {
        case None    => v :: res
        case Some(w) => loop(w, v :: res)
      }
    if (hasPathTo(v)) Some(loop(v, List()))
    else None
  }
}
