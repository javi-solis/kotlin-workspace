data class Edge(val nodeA: Node,
                 val nodeB: Node) {

    override fun equals(other: Any?): Boolean {
        if (other is Edge) {
            return (other.nodeA.equals(this.nodeA) &&
                    other.nodeB.equals(this.nodeB)) ||
                    (other.nodeA.equals(this.nodeB) &&
                            other.nodeB.equals(this.nodeA))
        }

        return false
    }
}