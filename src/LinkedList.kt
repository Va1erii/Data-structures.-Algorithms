import java.util.*

fun main() {
    val list = LinkedList<Int>()
    list.addLast(1) // O(1)
    list.addFirst(2) // O(1)
    list.add(1, 0) // O(n/2) search time
    println(list.joinToString(","))
}