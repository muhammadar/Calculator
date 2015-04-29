package com.example.muhammad.calculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    long currentValue;//current value
    char currentOp;//current operation
    long storedValue;//stored value in memory
    boolean isLatestInputOperation;//is the latest input an operation
    TextView displayedValue_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentValue=0;
        storedValue= 0;
        currentOp='n';//no operation
        displayedValue_textView = (TextView) findViewById(R.id.displayedValue_textView);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void clearScreen(){
        displayedValue_textView.setText("0");
    }

    private boolean isDisplayFull(){
        String text = (String) displayedValue_textView.getText();
        if(text.charAt(0)=='-' && text.length() > 9)
            return true;
        else if(text.charAt(0)!='-' && text.length() > 8)
            return true;
        else
            return false;
    }

    public void click_button_C(View view){
        clearScreen();
        currentOp='n';
        currentValue=0;
        isLatestInputOperation=false;
    }

    public void click_button_back(View view){
        String text = (String) displayedValue_textView.getText();
        if(text.length()==1)
            text="0";
        else {
            String sub = text.substring(0, text.length() - 1);
            text = sub;
        }
        displayedValue_textView.setText(text);
        isLatestInputOperation=false;
    }

    public void click_button_MPlus(View view){
        storedValue+=Long.valueOf(displayedValue_textView.getText().toString()).longValue();
        clearScreen();
        currentOp='n';
        currentValue=0;
        isLatestInputOperation=false;
    }

    public void click_button_MR(View view){
        if(isLatestInputOperation)
            clearScreen();
        displayedValue_textView.setText(String.valueOf(storedValue));
        isLatestInputOperation=false;
    }

    public void click_button_MC(View view){
        storedValue=0;
        clearScreen();
        currentValue=0;
        isLatestInputOperation=false;
    }

    public void click_button_N(View view){
        if(isLatestInputOperation && currentOp!='n')
            clearScreen();
        String text = (String) displayedValue_textView.getText();
        if(text.charAt(0)!='-')
            text="-"+text;
        else if(text.charAt(0)=='-'){
            String sub = text.substring(1,text.length());
            text=sub;
        }
        displayedValue_textView.setText(text);
        isLatestInputOperation=false;
    }

    public void click_button_equals(View view){
        long temp = currentValue;
        if(currentOp=='n')
            currentValue = Long.valueOf(displayedValue_textView.getText().toString()).longValue();
        else{
            calcResult();
        }

        if (checkValueLengthToBeDisplayed()) {
            currentValue=0;
            currentOp = 'n';
            isLatestInputOperation = true;
        }
        else
            currentValue = temp;
    }

    private void calcResult(){
        if(!isLatestInputOperation){
            long input = Long.valueOf(displayedValue_textView.getText().toString()).longValue();
            switch (currentOp){
                case '+':
                    currentValue=currentValue+input;
                    break;
                case '-':
                    currentValue=currentValue-input;
                    break;
                case '*':
                    currentValue=currentValue*input;
                    break;
                case '/':
                    if(input==0)
                        displayedValue_textView.setText("ERR /0");
                    else
                        currentValue=currentValue/input;
            }
        }
    }

    public void operation(char op){
        long temp = currentValue;
        if(currentOp=='n')
            currentValue = Long.valueOf(displayedValue_textView.getText().toString()).longValue();
        else
            calcResult();

        if (checkValueLengthToBeDisplayed()) {
            currentOp = op;
            isLatestInputOperation = true;
        }
        else
            currentValue = temp;
    }

    public void click_button_add(View view){
        operation('+');
    }
    public void click_button_minus(View view){
        operation('-');
    }
    public void click_button_mul(View view){
        operation('*');
    }
    public void click_button_div(View view){
        operation('/');
    }

    public void click_button_0(View view){
        if(isLatestInputOperation)
            clearScreen();
        if(!isDisplayFull()) {
            String text = (String) displayedValue_textView.getText();
            if (!text.equals("0"))
                text += "0";
            displayedValue_textView.setText(text);
            isLatestInputOperation = false;
        }
    }

    public void click_button_1(View view){
        if(isLatestInputOperation)
            clearScreen();
        if(!isDisplayFull()) {
            String text = (String) displayedValue_textView.getText();
            if (text.equals("0") || text.equals("-0"))
                text = text.replace('0','1');
            else
                text += "1";
            displayedValue_textView.setText(text);
            isLatestInputOperation = false;
        }
    }

    public void click_button_2(View view){
        if(isLatestInputOperation)
            clearScreen();
        if(!isDisplayFull()) {
            String text = (String) displayedValue_textView.getText();
            if (text.equals("0") || text.equals("-0"))
                text = text.replace('0','2');
            else
                text += "2";
            displayedValue_textView.setText(text);
            isLatestInputOperation = false;
        }
    }

    public void click_button_3(View view){
        if(isLatestInputOperation)
            clearScreen();
        if(!isDisplayFull()) {
            String text = (String) displayedValue_textView.getText();
            if (text.equals("0") || text.equals("-0"))
                text = text.replace('0','3');
            else
                text += "3";
            displayedValue_textView.setText(text);
            isLatestInputOperation = false;
        }
    }

    public void click_button_4(View view){
        if(isLatestInputOperation)
            clearScreen();
        if(!isDisplayFull()) {
            String text = (String) displayedValue_textView.getText();
            if (text.equals("0") || text.equals("-0"))
                text = text.replace('0','4');
            else
                text += "4";
            displayedValue_textView.setText(text);
            isLatestInputOperation = false;
        }
    }

    public void click_button_5(View view){
        if(isLatestInputOperation)
            clearScreen();
        if(!isDisplayFull()) {
            String text = (String) displayedValue_textView.getText();
            if (text.equals("0") || text.equals("-0"))
                text = text.replace('0','5');
            else
                text += "5";
            displayedValue_textView.setText(text);
            isLatestInputOperation = false;
        }
    }

    public void click_button_6(View view){
        if(isLatestInputOperation)
            clearScreen();
        if(!isDisplayFull()) {
            String text = (String) displayedValue_textView.getText();
            if (text.equals("0") || text.equals("-0"))
                text = text.replace('0','6');
            else
                text += "6";
            displayedValue_textView.setText(text);
            isLatestInputOperation = false;
        }
    }

    public void click_button_7(View view){
        if(isLatestInputOperation)
            clearScreen();
        if(!isDisplayFull()) {
            String text = (String) displayedValue_textView.getText();
            if (text.equals("0") || text.equals("-0"))
                text = text.replace('0','7');
            else
                text += "7";
            displayedValue_textView.setText(text);
            isLatestInputOperation = false;
        }
    }

    public void click_button_8(View view){
        if(isLatestInputOperation)
            clearScreen();
        if(!isDisplayFull()) {
            String text = (String) displayedValue_textView.getText();
            if (text.equals("0") || text.equals("-0"))
                text = text.replace('0','8');
            else
                text += "8";
            displayedValue_textView.setText(text);
            isLatestInputOperation = false;
        }
    }

    public void click_button_9(View view){
        if(isLatestInputOperation)
            clearScreen();
        if(!isDisplayFull()) {
            String text = (String) displayedValue_textView.getText();
            if (text.equals("0") || text.equals("-0"))
                text = text.replace('0','9');
            else
                text += "9";
            displayedValue_textView.setText(text);
            isLatestInputOperation = false;
        }
    }

    private boolean checkValueLengthToBeDisplayed(){
        String text = String.valueOf(currentValue);
        if((text.charAt(0)=='-' && text.length() <= 10) || (text.charAt(0)!='-' && text.length() <= 9)) {
            displayedValue_textView.setText(String.valueOf(currentValue));
            return true;
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Too large", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }
}
