import java.lang.IllegalArgumentException

class Graph {
    private var nodes: MutableSet<Node> = mutableSetOf()
    private var edges: MutableSet<Edge> = mutableSetOf()
    private var alreadyVisited: MutableSet<Node> = mutableSetOf()

    fun createNode(node: Node) {
        this.nodes.add(node)
    }

    fun createRelation(nodeA: Node, nodeB: Node) {
        if (!this.nodes.contains(nodeA) || !this.nodes.contains(nodeB)) {
            throw IllegalArgumentException("The nodes must be added first")
        }

        this.edges.add(Edge(nodeA, nodeB))
    }

    private fun selectTheOtherNode(edge: Edge, node: Node): Node {
        if (edge.nodeA.equals(node)) {
            return edge.nodeB
        } else {
            return edge.nodeA
        }
    }

    private fun searchConnectedNodes(node: Node): List<Node> {
        return this.edges.filter { it.nodeA.equals(node) || it.nodeB.equals(node) }
            .map { selectTheOtherNode(it, node) }
    }

    fun searchByName(node: Node, name: String) {
        alreadyVisited = mutableSetOf()
        recursiveSearch(node, name)
    }

    private fun recursiveSearch(node: Node, criteria: String) {
        if (node.name.equals(criteria)) {
            System.out.println(node)
        }
        alreadyVisited.add(node)

        val connectedNodes: List<Node> = searchConnectedNodes(node).minus(alreadyVisited)
        for (connectedNode in connectedNodes) {
            if (connectedNode.name.equals(criteria)) {
                System.out.println("The node $connectedNode was found")
            } else {
                recursiveSearch(connectedNode, criteria)
            }
        }
    }
}

