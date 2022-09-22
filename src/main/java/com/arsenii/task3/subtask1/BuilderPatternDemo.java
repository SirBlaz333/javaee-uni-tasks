package com.arsenii.task3.subtask1;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareVeganMeal();
        printMeal(meal);
        meal = mealBuilder.prepareNonVeganMeal();
        printMeal(meal);
    }

    private static void printMeal(Meal meal){
        System.out.println("Cost of the meal: " + meal.getCost());
        meal.showItems();
    }
}
