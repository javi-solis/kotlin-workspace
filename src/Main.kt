fun fibonacci (number: Int): Int {
    if (number == 0) {
        return 0
    }
    if (number == 1) {
        return 1
    }

    return (fibonacci(number - 1) + fibonacci(number - 2))
}

fun graphSetup () {
    val graphService = Graph()

    val javi = Node("Javi", "Argentina")
    val gabi = Node("Gabi", "Argentina")
    val sil = Node("Sil", "Argentina")
    val raul = Node("Raul", "Argentina")
    val valen = Node("Valen", "Argentina")
    val cris = Node("Cris", "Argentina")
    val amalia = Node("Amalia", "Argentina")
    val tony = Node("Tony", "Argentina")

    graphService.createNode(javi)
    graphService.createNode(gabi)
    graphService.createNode(sil)
    graphService.createNode(raul)
    graphService.createNode(valen)
    graphService.createNode(cris)
    graphService.createNode(amalia)
    graphService.createNode(tony)

    graphService.createRelation(javi, gabi)
    graphService.createRelation(javi, valen)
    graphService.createRelation(javi, tony)
    graphService.createRelation(javi, amalia)
    graphService.createRelation(sil, valen)
    graphService.createRelation(sil, raul)
    graphService.createRelation(sil, cris)
    graphService.createRelation(gabi, amalia)
    graphService.createRelation(gabi, tony)

    graphService.searchByName(valen, "Cris")
}

fun main() {
    val takeElements = 20
    val naturalNumbers = generateSequence(0) { it + 1 }

    System.out.println(naturalNumbers
        .map { "fibonacci of $it is ${fibonacci(it)}"}
        .take(takeElements)
        .toList())
}