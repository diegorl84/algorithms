Branch Sums
<p>
  Write a function that takes in a Binary Tree and returns a list of its branch
  sums ordered from leftmost branch sum to rightmost branch sum.
</p>
<p>
  A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree
  branch is a path of nodes in a tree that starts at the root node and ends at
  any leaf node.
</p>
<p>
  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. Children
  nodes can either be <span>BinaryTree</span> nodes themselves or
  <span>None</span> / <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">tree</span> =     1
        /     \
       2       3
     /   \    /  \
    4     5  6    7
  /   \  /
 8    9 10
</pre>
<h3>Sample Output</h3>
<pre>[15, 16, 18, 10, 11]
<span class="CodeEditor-promptComment">// 15 == 1 + 2 + 4 + 8</span>
<span class="CodeEditor-promptComment">// 16 == 1 + 2 + 4 + 9</span>
<span class="CodeEditor-promptComment">// 18 == 1 + 2 + 5 + 10</span>
<span class="CodeEditor-promptComment">// 10 == 1 + 3 + 6</span>
<span class="CodeEditor-promptComment">// 11 == 1 + 3 + 7</span>
</pre>