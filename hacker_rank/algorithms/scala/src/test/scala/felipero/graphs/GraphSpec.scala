package felipero.graphs

import org.scalatest._

class GraphSpec extends FunSpec with Matchers {

  describe("A Graph") {
    describe(":+") {
      it("should add a new node to the graph nodes") {
        val root = new GraphNode(1)
        val graph = new Graph(root)
        graph :+ new GraphNode(2)
        graph.nodes.size shouldEqual 2
        graph :+ new GraphNode(3)
        graph.nodes.size shouldEqual 3
      }
    }

    describe("connect") {
      it("should connect two given nodes in the graph") {
        val root = new GraphNode(1)
        val graph = new Graph(root)
        val node = new GraphNode(2)
        graph :+ node
        graph connect (root, node)
        graph.nodes.size shouldEqual 2
        graph.nodes.apply(root) shouldEqual Set[GraphNode](node)

        // Adding nested nodes
        val otherNode = new GraphNode(3)
        graph :+ otherNode
        graph connect (node, otherNode)
        graph.nodes.apply(root) shouldEqual Set[GraphNode](node)
        graph.nodes.apply(node) shouldEqual Set[GraphNode](otherNode)

        // Adding duplicated nodes
        graph connect (root, new GraphNode(2))
        graph.nodes.apply(root) shouldEqual Set[GraphNode](node)
        graph.nodes.apply(otherNode) shouldEqual Set[GraphNode]()
      }
    }

    describe("inspectDistance") {
      it("should return distance from node to all other nodes") {
        val root = new GraphNode(1)
        val graph = new Graph(root)
        val nodeTwo = new GraphNode(2)
        val nodeThree = new GraphNode(3)
        val nodeFour = new GraphNode(4)
        val nodeFive = new GraphNode(5)
        val nodeSix = new GraphNode(6)

        graph :+ nodeTwo
        graph :+ nodeThree
        graph :+ nodeFour
        graph :+ nodeFive
        graph :+ nodeSix
        graph connect (root, nodeTwo)
        graph connect (root, nodeThree)
        graph connect (nodeThree, nodeFour)
        graph connect (nodeFive, nodeSix)

        graph inspectDistance (root) shouldEqual Array(6, 6, 12, -1, -1)
      }

      it(
        "should return distance from node to all other nodes and a different root"
      ) {
        val root = new GraphNode(2)
        val graph = new Graph(root)
        val nodeOne = new GraphNode(1)
        val nodeThree = new GraphNode(3)
        val nodeFour = new GraphNode(4)
        val nodeFive = new GraphNode(5)
        val nodeSix = new GraphNode(6)
        val nodeSeven = new GraphNode(7)

        graph :+ nodeOne
        graph :+ nodeThree
        graph :+ nodeFour
        graph :+ nodeFive
        graph :+ nodeSix
        graph :+ nodeSeven
        graph connect (root, nodeFour)
        graph connect (root, nodeThree)
        graph connect (nodeFour, nodeOne)
        graph connect (nodeFive, nodeSix)
        graph connect (nodeOne, nodeSeven)

        graph inspectDistance (root) shouldEqual Array(12, 6, 6, -1, -1, 18)
      }

      it("should return distance even when node is connect backwards") {
        val root = new GraphNode(3)
        val graph = new Graph(root)
        val nodeOne = new GraphNode(1)
        val nodeTen = new GraphNode(10)

        graph :+ nodeOne
        graph :+ nodeTen
        graph connect (root, nodeOne)
        graph connect (nodeTen, nodeOne)

        println(graph.nodes.mkString("\n"))

        graph inspectDistance (root) shouldEqual Array(6, 12)
      }
    }
  }
}
