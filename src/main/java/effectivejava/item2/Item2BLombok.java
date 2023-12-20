package effectivejava.item2;

import org.junit.Test;

/**
 * Builder pattern to get objects. Builder is typically a static member class
 */
public class Item2BLombok {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public Item2BLombok(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static NutritionFactsLombokBuilder builder(){
        return new NutritionFactsLombokBuilder();
    }

    public static class NutritionFactsLombokBuilder{
        private int servingSize;
        private int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public NutritionFactsLombokBuilder() {
        }

        public NutritionFactsLombokBuilder servingSize(int servingSize){
            this.servingSize = servingSize;
            return this;
        }

        public NutritionFactsLombokBuilder servings(int servings){
            this.servings = servings;
            return this;
        }
        public NutritionFactsLombokBuilder calories(int val){
            this.calories = val;
            return this;
        }
        public NutritionFactsLombokBuilder fat(int val){
            this.fat = val;
            return this;
        }
        public NutritionFactsLombokBuilder sodium(int val){
            this.sodium = val;
            return this;
        }
        public NutritionFactsLombokBuilder carbohydrate(int val){
            this.carbohydrate = val;
            return this;
        }
        public Item2BLombok build(){
            return new Item2BLombok(servingSize, servings, calories, fat, sodium, carbohydrate);
        }

    }

    @Test
    public void test(){
        Item2BLombok nutritionFacts = Item2BLombok.builder().servings(1).servingSize(1).calories(100).carbohydrate(100).build();
    }
}
