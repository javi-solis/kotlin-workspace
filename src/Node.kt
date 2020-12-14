data class Node (val name : String,
                 val nationality : String) {

    override fun equals(other: Any?): Boolean {
        if (other is Node) {
            return name?.equals(other.name)
        }

        return false
    }
}
