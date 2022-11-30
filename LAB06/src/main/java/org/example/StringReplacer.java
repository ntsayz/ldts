package org.example;
//l10gr
public class StringReplacer implements StringTransformer {

    private char curr, next;
    public StringReplacer(char curr, char next){
        this.curr = curr;
        this.next = next;
    }
    @Override
    public void execute(StringDrink drink) {
        StringBuilder str = new StringBuilder(drink.getText());

        for(int i =0 ; i < drink.getText().length() ; i++){
            char c = str.charAt(i);
            if(c == this.curr){
                str.setCharAt(i,this.next);
            }
        }
        drink.setText(str.toString());
    }

    @Override
    public void undo(StringDrink drink) {

    }
}
