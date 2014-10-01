package algorithms.graph.data

/**
 * Adjacency lists representation of undirected graph
 */
class Graph(val numberOfVertices: Int) {

  private val adj: Array[List[Int]] =
    (0 until numberOfVertices).map(_ => List()).toArray

  private var numOfEdges: Int = 0

  def numberOfEdges: Int = numOfEdges

  def addEdge(v1: Int, v2: Int): Graph = {
    adj(v1) = v2 :: adj(v1)
    adj(v2) = v1 :: adj(v2)
    numOfEdges += 1
    this
  }

  def adjacencies(v: Int): List[Int] = adj(v)

  override def toString: String =
    "v = %s, e = %s\n".format(numberOfVertices, numOfEdges) +
      adj.zipWithIndex
      .map(a => "%s: %s".format(a._2, a._1.mkString("->")))
      .mkString("\n")

}
