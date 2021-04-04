fun main() {
    val array = Array(10) { 0 }
    val access = array[1] // O(1)
    array[1] = 1 // O(1)
    println(access)
    println(array.joinToString(","))
}