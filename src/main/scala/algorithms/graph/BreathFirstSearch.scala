package algorithms.graph

import scala.collection.mutable.Queue
import algorithms.graph.data.Graph

class BreathFirstSearch(g: Graph) extends Search {

  def search(s: Int): SearchResult = {
    val res = new SearchResult(g.numberOfVertices)
    val q = new Queue[Int]
    q.enqueue(s)
    res.marked(s) = true
    while (!q.isEmpty) {
      val v = q.dequeue
      for (adj <- g.adjacencies(v) if !res.marked(adj)) {
        res.predecessor(adj) = Some(v)
        q.enqueue(adj)
        res.marked(adj) = true
      }
    }
    res
  }

}
