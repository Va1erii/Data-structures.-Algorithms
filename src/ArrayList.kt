fun main() {
    val list = ArrayList<Int>()
    list.add(1) // O(1) or O(n). Depends on load factor 0.75
    list.removeLast() // O(1)

    list.add(0, 1) // O(n)
    list.removeAt(0) // O(n)
}