package algorithms.graph

import algorithms.graph.data.Graph

class DepthFirstSearch(g: Graph) extends Search {

  def search(s: Int): SearchResult = {
    val result = new SearchResult(g.numberOfVertices)
    dfs(s, result)
    result
  }

  private def dfs(v: Int, res: SearchResult) {
    res.marked(v) = true
    for (adj <- g.adjacencies(v) if !res.marked(adj)) {
      res.predecessor(adj) = Some(v)
      dfs(adj, res)
    }
  }

}
