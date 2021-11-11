### Math
1. Number of digits in a number: (int) (Math.log10(N) + 1)
2. Number of combinations given a string: n*(n+1)/2
3. Convert an integer to char: (char) int
4. Convert a char to an integer: (int) char
5. Decimal values starts from: A->65 , a-> 97
6. Converting integer to binary String: Integer.toBinaryString(int i)
7. To get difference in bits between two integers use XOR operation (ex: 4 ^ 1)

### Bitwise Operations:
| A | B | A or B | A&B | A^B | ~A |
| :---: | :---: | :---: | :---: | :---: | :---: |
|0|0|0|0|0|1|
|1|0|1|0|1|0|
|0|1|1|0|1|0|
|1|1|1|1|0|0|

### Problem Namings:
1. Hamming Distance - Bitwise difference between two integers.
2. Anagrams - All characters in string A must be present in String B


## TREES:
### Binary Trees:

Total number of nodes in a binary tree: 2^(h+1) -1

#### Complete Binary Trees:
1. All levels must be filled except last level (and to the left of each node).
2. Total number of nodes are 2^(h+1) -1, where h is the height of the tree.
3. Total number of non leaf nodes are 2^h -1.
4. Total number of leaf nodes are 2^h.

#### Proper/Full Binary Trees:
1. Every node has 0 or 2 children. No node can have 1 child.

#### Perfect Binary Trees:
1. If a tree is both complete and Full, then it is a perfect binary tree.

#### Insertion:
1. Start with root
2. Fill left, move to right.
3. Continue step 2, until all the nodes are filled.
4. There should be no right node without left node.

### Binary Search Trees:
Properties:
1. Left child must be less than root.
2. Right child must be greater than root.<br>
***|left-child| <= root < |right-child|***

Insertion:
1. Can be done Iterative or Recursive approach.
2. Find value, insert right or left to the root.

Deletion: <br>
Scenario A: Delete leaf node
1. Traverse to the leaf node and delete it. <br>

Scenario B: Delete parent node with one child.
1. Find the parent node to be deleted.
2. Link the child node of the parent node to be deleted with parent of the parent node.
3. Delete actual parent node.

Scenario C: Delete parent node with two children
1. Find parent node to be deleted.
2. Traverse all the way to down to the last parent node.
3. Swap the parent node to be deleted with left child of the parent node from step2.
4. Delete the child node.


Traversals:
1. PREORDER: ROOT -> LEFT -> RIGHT
2. INORDER: LEFT -> ROOT -> RIGHT
2. POSTORDER: LEFT -> RIGHT -> ROOT

Preorder is equal to depth first search. We use Stacks to implement it.
Inorder always gives ascending order.
