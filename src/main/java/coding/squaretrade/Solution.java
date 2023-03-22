package coding.squaretrade;

import java.util.*;

public class Solution {

    Object[][] data = {
            {1, "Root", "Products", -1},
            {2, "Furniture", "Furniture", 1},
            {3, "Electronics", "Electronics, Gadgets", 1},
            {4, "Home Appliances", "", 1},
            {5, "Major Appliances", "", 4},
            {6, "Minor Appliances", "", 4},
            {7, "Lawn & Garden", "Lawn, Garden", 4},
            {8, "Kitchen Appliances", "", 5},
            {9, "General Appliances", "", 5},

    };

    /**
     * Data is a collection of records: with id, name, keywords and parent_id
     * If a record does not have keyWord it will inheritate from its father:
     * e.i:
     * a. Keywords for record id=3 is Electronics, Gadgets
     * b. KeyWords for record id=4 is empty. It will take the parent's keyword so record id=4 keywords=Products
     *
     * Root element is level 0
     * Children's are level 1 and so on. Which means that for record 5 the level is 2, because root -> Home Appliances -> Major Appliances
     *
     * 1. Giving this information, create a structure and put that information
     * 2. Create a method to get keyWorks from index getKeyWorks(8) = Furniture
     * 3. Create a method to get level by id
     * 4. Package these to a variable in a String[] : "level, keyworks' solution(2) = {1,Furniture}
     */


    private final Map<Integer, Node> categories = new HashMap<>();

    public String[] solution(int categoryID) {
        populateCategories();
        String[] ans = new String[]{getLevel(categoryID), getKeywordsByCategoryId(categoryID)};
        return ans;

    }

    /**
     * Populates data categories in Map < categoryId, ListNode >
     * Assumption: If parentID does not exist use root as parent
     * Assumption: If parentId is same as categoryId (recursive point) use root as parent
     */
    public void populateCategories(){
        for (Object[] row : data) {
            if(row.length != 4){
                throw new RuntimeException();
            }
            int parentId = row[0] == row[3] ? -1 : (int) row[3];
            final Node node = new Node((int) row[0], String.valueOf(row[1]), String.valueOf(row[2]), categories.getOrDefault(parentId, categories.get(1)));
            categories.put((Integer) row[0], node);
        }
    }

    public String getKeywordsByCategoryId(int categoryId) {
        Node category = categories.get(categoryId);
        if (category != null) {
            while (category.keyWords.isBlank() && category.parent != null) {
                category = category.parent;
            }
        }
        return category.keyWords;
    }

    public String getLevel(int categoryId) {
        Node category = categories.get(categoryId);
        int level = 0;
        while(category.parent != null){
            category = category.parent;
            level++;
        }
        return String.valueOf(level);
    }

}
 class Node {
     Integer id;
     String categoryName;
     String keyWords;
     Node parent;

     public Node(Integer id, String categoryName, String keyWords, Node parent) {
         this.id = id;
         this.categoryName = categoryName;
         this.keyWords = keyWords;
         this.parent = parent;
     }
 }
