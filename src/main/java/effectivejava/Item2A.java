package effectivejava;

import org.junit.Test;

/**
 * Builder pattern to get objects. Builder is typically a static member class
 */
public class Item2A {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    private Item2A(Builder builder){
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static class Builder{
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings){
            this.servings = servings;
            this.servingSize = servingSize;
        }
        public Builder calories(int val){
            this.calories = val;
            return this;
        }
        public Builder fat(int val){
            this.fat = val;
            return this;
        }
        public Builder sodium(int val){
            this.sodium = val;
            return this;
        }
        public Builder carbohydrate(int val){
            this.carbohydrate = val;
            return this;
        }
        public Item2A build(){
            return new Item2A(this);
        }

    }

    @Test
    public void test(){
        Item2A nutritionFacts = new Item2A.Builder(1 , 1).calories(100).carbohydrate(100).build();
    }
}
