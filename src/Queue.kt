import java.util.*

interface Queue<T> {
    fun add(element: T) // Add to the end of queue
    fun poll(): T? // Get an element from the end of queue
}

interface Dequeue<T> : Queue<T> {
    fun push(element: Int) // Add to the start of dequeue
    fun pop(): Int? // Get an element from the start of dequeue
}

class DequeueList : Dequeue<Int> {
    private val dequeue = LinkedList<Int>()

    override fun push(element: Int) {
        dequeue.push(element)
    }

    override fun pop(): Int? {
        return dequeue.pop()
    }

    override fun add(element: Int) {
        dequeue.add(element)
    }

    override fun poll(): Int? {
        return dequeue.poll()
    }

    override fun toString(): String {
        return dequeue.joinToString(",", "[", "]")
    }
}

class DequeueArray(size: Int) : Dequeue<Int> {
    private var dequeue = Array<Int?>(size) { null }
    private var currentSize = 0

    override fun push(element: Int) {
        if (currentSize < dequeue.size) {
            val prev = dequeue.copyOf(dequeue.size)
            dequeue[0] = element
            prev.forEachIndexed { index, i -> if (index < dequeue.size - 1) dequeue[index + 1] = i }
            currentSize++
        }
    }

    override fun pop(): Int? {
        return if (currentSize > 0) {
            val res = dequeue[0]
            dequeue = dequeue.copyOfRange(1, dequeue.size)
            currentSize--
            res
        } else {
            null
        }
    }

    override fun add(element: Int) {
        if (currentSize < dequeue.size) {
            dequeue[currentSize++] = element
        }
    }

    override fun poll(): Int? {
        return if (currentSize > 0) {
            val res = dequeue[currentSize]
            dequeue[currentSize--] = null
            res
        } else {
            null
        }
    }

    override fun toString(): String {
        return dequeue.asSequence().filter { it != null }.joinToString(",", "[", "]")
    }
}

fun main() {
    println("DEQUEUE LIST PART:")

    val dequeueList: Dequeue<Int> = DequeueList()
    dequeueList.add(2)
    dequeueList.push(1)
    println(dequeueList.toString())

    dequeueList.pop()
    println(dequeueList.toString())

    println("DEQUEUE ARRAY PART:")
    val dequeueArray: Dequeue<Int> = DequeueArray(10)
    dequeueArray.add(2)
    dequeueArray.push(1)
    println(dequeueArray.toString())

    dequeueArray.pop()
    println(dequeueArray.toString())
}