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

## ArrayList

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

## Stacks
