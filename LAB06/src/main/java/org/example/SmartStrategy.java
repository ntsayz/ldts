package org.example;

public class SmartStrategy implements OrderingStrategy{

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour() ){
            bar.order(drink,recipe);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {


    }

    @Override
    public void happyHourEnded(StringBar bar) {
        bar.endHappyHour();
    }
}
