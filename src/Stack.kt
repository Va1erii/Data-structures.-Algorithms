import java.util.*

interface Stack<T> {
    fun pop(): T?
    fun push(element: T): Boolean
}

class StackArray(size: Int) : Stack<Int> {
    private val array = Array<Int?>(size) { null }
    private var currentIndex = 0

    override fun pop(): Int? {
        val result = array[currentIndex]
        array[currentIndex] = null
        if (currentIndex > 0) currentIndex--
        return result
    }

    override fun push(element: Int): Boolean {
        return if (currentIndex >= array.size) {
            false
        } else {
            array[currentIndex++] = element
            true
        }
    }

    override fun toString(): String {
        return array.copyOfRange(0, currentIndex).joinToString(",", "[", "]")
    }
}

class StackList : Stack<Int> {
    private val list = LinkedList<Int?>()

    override fun pop(): Int? {
        return list.pollLast()
    }

    override fun push(element: Int): Boolean {
        list.add(element)
        return true
    }

    override fun toString(): String {
        return list.joinToString(",", "[", "]")
    }
}

fun main() {
    val stackArray = StackArray(10)
    stackArray.push(1)
    stackArray.push(2)
    stackArray.pop()
    stackArray.push(4)
    println(stackArray.toString())

    val stackList = StackList()
    stackList.push(1)
    stackList.push(2)
    stackList.pop()
    stackList.push(4)
    println(stackList.toString())
}