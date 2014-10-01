package algorithms.graph

import org.hamcrest.Matchers._
import org.junit.Assert._
import org.junit.Test
import algorithms.graph.data.Graph

class GraphTest {

  @Test
  def graph {
    val g = new Graph(5)
    assertThat(g.numberOfVertices, is(5))
    assertThat(g.numberOfEdges, is(0))

    g.addEdge(0, 1).addEdge(0, 2).addEdge(3, 4)
    assertThat(g.numberOfEdges, is(3))
    assertThat(g.adjacencies(0), is(List(2, 1)))
  }

  @Test
  def dfs {
    test(new DepthFirstSearch(_), List(0, 6, 4))
  }

  @Test
  def bfs {
    test(new BreathFirstSearch(_), List(0, 6, 4))
  }

  private def test(search: Graph => Search, pathTo: Iterable[Int]) {
    val g = new Graph(13)
      .addEdge(0, 5)
      .addEdge(4, 3)
      .addEdge(0, 1)
      .addEdge(9, 12)
      .addEdge(6, 4)
      .addEdge(5, 4)
      .addEdge(0, 2)
      .addEdge(11, 12)
      .addEdge(9, 10)
      .addEdge(0, 6)
      .addEdge(7, 8)
      .addEdge(9, 11)
      .addEdge(5, 3)
    val s = search(g)
    val result = s.search(0)
    val hasPaths =
      for (v <- 0 until g.numberOfVertices if result.hasPathTo(v))
        yield v
    assertThat(hasPaths, is(Seq(0, 1, 2, 3, 4, 5, 6)))
    assertThat(result.pathTo(4).get, is(pathTo: Iterable[Int]))
  }

}
