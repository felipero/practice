package felipero.graphs

import scala.io.Source
import scala.collection.mutable.{SortedMap, Map, Queue}

class GraphNode(val value: Int) {
  override def toString() = value.toString
  override def hashCode(): Int = value.hashCode
  override def equals(obj: scala.Any): Boolean = {
    obj match {
      case other: GraphNode => other.value == value
      case _                => false
    }
  }
}

class Graph(val root: GraphNode) {
  val nodeOrdering: Ordering[GraphNode] = Ordering.by(_.value)
  var nodes = Map[GraphNode, Set[GraphNode]](root -> Set[GraphNode]())

  def :+(node: GraphNode) = {
    nodes += (node -> Set[GraphNode]())
  }

  def connect(one: GraphNode, other: GraphNode) = {
    if (!nodes.contains(other) || !nodes.contains(one))
      throw new Exception(
        s"Nodes ${one.value} or ${other.value} does not belong to this graph"
      )
    nodes += (one -> nodes.apply(one).incl(other))
  }

  def inspectDistance(start: GraphNode): Array[Int] = {
    val distances = SortedMap[GraphNode, Int]()(nodeOrdering)

    val queue = new Queue[GraphNode]
    queue.enqueue(start)

    val visited = Set[GraphNode](start)

    while (!queue.isEmpty) {
      val node = queue.dequeue
      visited.incl(node)
      println("\n\n\n\nQUEUE:\n")
      println(queue)

      val parentDistance: Int = distances.getOrElse(node, 0)

      for (childNode <- nodes.apply(node)) {
        distances += (childNode -> (parentDistance + 6))
        if (!visited.contains(childNode))
          queue.enqueue(childNode)
      }
    }

    for (node <- (nodes.keySet -- visited)
         if !distances.contains(node) && node != start)
      distances += (node -> -1)

    Array.from(distances.values)
  }
}

object BFSShortestReach {

  def bfs(n: Int, m: Int, edges: Array[Array[Int]], s: Int): Array[Int] = {
    val root = new GraphNode(s)
    val graph = new Graph(root)

    for (value <- 1 to n) {
      if (value != s)
        graph :+ new GraphNode(value)
    }

    for (edge <- edges) {
      graph connect (new GraphNode(edge(0)), new GraphNode(edge(1)))
    }

    graph.inspectDistance(root)
  }

  def execute(input: String): String = {
    val inputSource = Source.fromString(input)
    val lines = inputSource.getLines

    var output = Array[Array[Int]]()

    val q = lines.next.trim.toInt

    for (qItr <- 1 to q) {
      val nm = lines.next.split(" ")

      val n = nm(0).trim.toInt
      val m = nm(1).trim.toInt

      val edges = Array.ofDim[Int](m, 2)

      for (i <- 0 until m) {
        edges(i) = lines.next.split(" ").map(_.trim.toInt)
      }

      val s = lines.next.trim.toInt

      val result = bfs(n, m, edges, s)

      output = output :+ result
    }

    inputSource.close

    output.map(_.mkString(" ")).mkString("\n")
  }
}
