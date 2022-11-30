package org.example;

public class StringCaseChanger implements StringTransformer {
    public void execute(StringDrink drink) {
        StringBuilder str = new StringBuilder(drink.getText());
        for(int i =0 ; i < drink.getText().length() ; i++){
            char c = str.charAt(i);
            if(Character.isLowerCase(c)){
                    str.setCharAt(i,Character.toUpperCase(c));
            }else{
                str.setCharAt(i,Character.toLowerCase(c));
            }
        }
        drink.setText(str.toString());
    }
    @Override
    public void undo(StringDrink drink){

    }
}
