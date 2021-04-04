class BinaryHeap(
        size: Int,
        private val minHeap: Boolean = true
) {
    private val array = Array(size) { -1 }
    private var currentSize = 0

    fun addElement(element: Int) {
        if (minHeap) {
            minHeapAdd(element)
        } else {
            maxHeapAdd(element)
        }
    }

    // Min or Max
    fun rootHeap(): Int {
        return array[0]
    }

    private fun minHeapAdd(element: Int) {
        var i = currentSize
        // First insert the new key at the end
        array[i] = element
        currentSize++

        // Fix the min heap property if it is violated
        while (i != 0 && array[i] < array[parentNodeIndex(i)]) {
            swap(i, parentNodeIndex(i))
            i = parentNodeIndex(i)
        }
    }

    private fun maxHeapAdd(element: Int) {
        var i = currentSize
        // First insert the new key at the end
        array[i] = element
        currentSize++

        // Fix the min heap property if it is violated
        while (i != 0 && array[i] > array[parentNodeIndex(i)]) {
            swap(i, parentNodeIndex(i))
            i = parentNodeIndex(i)
        }
    }

    // Get the Parent index for the given index
    private fun parentNodeIndex(index: Int): Int {
        return (index - 1) / 2
    }

    // Get the Left Child index for the given index
    private fun leftNode(index: Int): Int {
        return 2 * index + 1
    }

    // Get the Right Child index for the given index
    private fun rightNode(index: Int): Int {
        return 2 * index + 2
    }

    private fun swap(from: Int, to: Int) {
        val temp = array[from]
        array[from] = array[to]
        array[to] = temp
    }

    override fun toString(): String {
        return array.copyOfRange(0, currentSize).joinToString(",", "[", "]")
    }
}

fun main() {
    val minHeap = BinaryHeap(10)
    minHeap.addElement(3)
    minHeap.addElement(1)
    minHeap.addElement(5)
    minHeap.addElement(6)
    minHeap.addElement(9)
    minHeap.addElement(8)

    println(minHeap.toString())

    val maxHeap = BinaryHeap(10, false)
    maxHeap.addElement(3)
    maxHeap.addElement(1)
    maxHeap.addElement(5)
    maxHeap.addElement(6)
    maxHeap.addElement(9)
    maxHeap.addElement(8)

    println(maxHeap.toString())
}