package healthIQ.charts;

import java.time.LocalDate;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class FoodItem {
    private MealType mealType;
    private String foodDesc;
    private double numOfServings;
    private double servingSize;
    private double protein;
    private double fat;
    private double carbs;
    private double fiber;
    private double sugar;
    private double calories;
    private LocalDate date;
    
    public FoodItem(MealType mealType, String foodDesc, float protein, float fat,
                    float carbs, float sugar, float fiber, LocalDate date){
        
        this.mealType = mealType;
        this.foodDesc = foodDesc;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.fiber = fiber;
        this.sugar = sugar;
        this.date = date;
        
    }//end constructor

    public MealType getMealType() {
        return mealType;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFiber() {
        return fiber;
    }

    public double getSugar() {
        return sugar;
    }

    public double getNumOfServings() {
        return numOfServings;
    }

    public double getServingSize() {
        return servingSize;
    }

    public double getCalories() {
        return calories;
    }
    
    public LocalDate getDate(){
        return date;
    }
    
    
}//end FoodItem
