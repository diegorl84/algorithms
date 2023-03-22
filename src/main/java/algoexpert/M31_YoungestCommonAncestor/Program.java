package algoexpert.M31_YoungestCommonAncestor;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 *
 */

public class Program {

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
      while (descendantOne.ancestor != null && descendantTwo.ancestor != null){
          if(descendantOne.ancestor == descendantTwo.ancestor){
              return descendantOne.ancestor;
          }
      }
        return topAncestor; // Replace this line
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }


    @Test
    public void TestCase1() {
        var trees = getTrees();
        trees.get('A').addAsAncestor(new Program.AncestralTree[] {trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new Program.AncestralTree[] {trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new Program.AncestralTree[] {trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new Program.AncestralTree[] {trees.get('F'), trees.get('G')});

        var yca = Program.getYoungestCommonAncestor(trees.get('A'), trees.get('E'), trees.get('I'));
        Assert.assertTrue(yca == trees.get('B'));
    }

    public HashMap<Character, AncestralTree> getTrees() {
        var trees = new HashMap<Character, Program.AncestralTree>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            trees.put(a, new Program.AncestralTree(a));
        }

        trees
                .get('A')
                .addAsAncestor(
                        new Program.AncestralTree[] {
                                trees.get('B'), trees.get('C'), trees.get('D'), trees.get('E'), trees.get('F')
                        });
        return trees;
    }
}
