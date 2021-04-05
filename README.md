# Data Structures

## Arrays

| Operation      | Time Complexity  |
| -------------  | ---------------- |
| Access                     | Θ(1) |
| Insert/delete at beginning | N/A  | 
| Insert/delete at end       | N/A  |
| Insert/delete in middle    | N/A  |
| Wasted space (average)     |  0   |

Inserting depends on how insertion should be implemented. Just override at specified index: Θ(1). Or Θ(n) if we want to
insert at specified index and move other part.

## ArrayList (Dynamic Lists)

| Operation      | Time Complexity  |
| -------------  | ---------------- |
| Access                     | Θ(1) |
| Insert/delete at beginning | Θ(n) | 
| Insert/delete at end       | Θ(1) (amortized) |
| Insert/delete in middle    | Θ(n) |
| Wasted space (average)     | Θ(n) |

Inserting an element cost Θ(1), but if size equals to the load factor (0.75f), a new array will be created and all
elements will be copied.

## [Linked Lists](src/LinkedList.kt)

| Operation      | Time Complexity  |
| -------------  | ---------------- |
| Access                     | Θ(n) |
| Insert/delete at beginning | Θ(1) | 
| Insert/delete at end       | Θ(1) |
| Insert/delete in middle    | Θ(1) + search time |
| Wasted space (average)     | Θ(n) |

Linked list is good choice if you don't exactly now how much data you want to store. The space will be the same as data
size. Also, it is a better for removing and adding items in the middle of the data. Queue/Dequeue could be implemented
via linked list.

## [Binary Heaps](src/BinaryHeap.kt)

| Operation      | Time Complexity  |
| -------------  | ---------------- |
| Find min/max               | Θ(1) |
| Delete min                 | Θ(log n) | 
| Insert                     | Θ(log n) |
| Decrease key               | Θ(log n) |

A Binary heap is a form of binary tree. All levels are completely filled except possibly the last level and the last
level has all keys as left as possible. This property of Binary Heap makes them suitable to be stored in an array. A
Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present
in Binary Heap

- Useful for quickly finding the minimum or maximum of a set of values.
- Useful for sorting values (heapsort)

<pre>
     10                  10 
    /  \                /  \  
  20   100            15    30  
  /    / \           /  \
30    40  50       100  40 
</pre>

## [Stacks](src/Stack.kt)

- LIFO (Last in, First Out)
- Abstract data type. Can be implemented a variety of ways. e.g. Arrays, linked lists, etc
- Generally implements push and pop operations

## [Queues](src/Queue.kt)

- FIFO (First in, First Out)
- Abstract data type. Can be implemented a variety of ways. e.g. Arrays, linked lists, etc.
- Generally implements push (enqueue) and pop (dequeue) operations.

## Trees

- A tree is an undirected, connected, acyclic graph
- Has v vertices and v-1 edges
- Any two vertices are connected by a unique path
- A leaf is a vertex of degree 1
- One node is designated as the root
- Each node has a parent and/or children pointers
- A node's height is the length of its path to the root
- A forest has multiple distinct trees (a disjoint union)
- An n-ary tree has at most n children per node

### Binary Trees

- A binary tree has nodes with at most 2 children (designated left & right)
- Full: every node has 0 or 2 children
    - Number of nodes is at most 2^(h+1)-1
- Complete: every level, except possibly the last, is filled, and the last level's nodes are as far left as possible
    - Number of internal nodes: floor(n/2)
- Balanced: has the minimum possible maximum depth
    - Height is ceil(lg(n+1))
- Traversals:
    - Pre-order: open current, visit left subtree, visit right subtree
    - In-order: visit left subtree, open current, visit right subtree (returns sorted list)
    - Post-order: visit left subtree, visit right subtree, open current
    - Level-order: breadth-first traversal, level by level

<pre>
     10                  10 
    /  \                /  \  
  20   100            15    30  
  /    / \           /  \
30    40  50       100  40
</pre>
Can be stored an array. See Binary Heap.

### Binary Search Trees

| Operation      | Average  | Worst Case |
| -------------  | ---------| ---------- |
| Search               | Θ(log n) | Θ(n) |
| Delete               | Θ(log n) | Θ(n) |
| Insert               | Θ(log n) | Θ(n) |

- A binary search tree is an ordered binary tree
- Satisfies the BST property: each node's value is greater than all keys stored in the left subtree and less than all
  keys stored in the right subtree
- Designed to make searching faster, each comparison allows operations to skip about half the tree

Worst case if a root element is the biggest one.