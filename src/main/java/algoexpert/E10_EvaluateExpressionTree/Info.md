Evaluate Expression Tree
<div class="BzHFKN85iSK6_k1lXqGC ae-workspace-dark"><div class="html">
  <p>
    You're given a binary expression tree. Write a function to evaluate
    this tree mathematically and return a single resulting integer.
  </p>

  <p>
    All leaf nodes in the tree represent operands, which will always be positive
    integers. All of the other nodes represent operators. There are 4 operators
    supported, each of which is represented by a negative integer:
  </p>

  <ul>
    <li>
      <span>-1</span>: Addition operator, adding the left and right subtrees.
    </li>
    <li>
      <span>-2</span>: Subtraction operator, subtracting the right subtree from the left subtree.
    </li>
    <li>
      <span>-3</span>: Division operator, dividing the left subtree by the right subtree.
      If the result is a decimal, it should be rounded towards zero.
    </li>
    <li>
      <span>-4</span>: Multiplication operator, multiplying the left and right subtrees.
    </li>
  </ul>

  <p>
    You can assume the tree will always be a valid expression tree. Each
    operator also works as a grouping symbol, meaning the bottom of the tree is
    always evaluated first, regardless of the operator.
  </p>

<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">tree</span> =    -1
        /     \
      -2       -3
     /   \    /  \
   -4     2  8    3
  /   \
 2     3
</pre>
<h3>Sample Output</h3>
<pre>6 <span class="CodeEditor-promptComment">// (((2 * 3) - 2) + (8 / 3))
</span>
</pre></div></div>