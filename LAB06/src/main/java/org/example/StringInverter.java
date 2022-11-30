package org.example;

public class StringInverter implements  StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        StringBuilder strbuilder = new StringBuilder(drink.getText());
        strbuilder.reverse();
        drink.setText(strbuilder.toString());
    }

    @Override
    public void undo(StringDrink drink) {

    }
}
