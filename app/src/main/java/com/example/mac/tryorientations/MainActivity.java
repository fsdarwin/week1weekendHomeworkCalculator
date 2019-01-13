package com.example.mac.tryorientations;

import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {

    //VARIABLES---------------
    String valueBulid = "";
    Float valueOne;
    Float valueTwo;
    boolean point = false;
    String operation = "";
    TextView tvInput;
    TextView tvResult;
    String memory;
    //------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INSTANCIATE VIEWS
        tvInput = findViewById(R.id.tvInput);
        tvResult = findViewById(R.id.tvResult);
    }
// onClick method for button presses
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClear:
                clear();//execute clear function
                break;
            case R.id.btnPower:
                setOperation("^");// store exponentiation for operation
                break;
            case R.id.btnBackSpace:
                back();//execute backspace function
                break;
            case R.id.btnDivision:
                setOperation("/");// operation is division
                break;
            case R.id.btnSeven:
                buildValue("7");//store digit and display string being built
                break;
            case R.id.btnEight:
                buildValue("8");//store digit and display string being built
                break;
            case R.id.btnNine:
                buildValue("9");//store digit and display string being built
                break;
            case R.id.btnMultiplication:
                setOperation("*");// operation is multiplication
                break;
            case R.id.btnFour:
                buildValue("4");//store digit and display string being built
                break;
            case R.id.btnFive:
                buildValue("5");//store digit and display string being built
                break;
            case R.id.btnSix:
                buildValue("6");//store digit and display string being built
                break;
            case R.id.btnSubtraction:
                setOperation("-");// operation is subtraction
                break;
            case R.id.btnOne:
                buildValue("1");//store digit and display string being built
                break;
            case R.id.btnTwo:
                buildValue("2");//store digit and display string being built
                break;
            case R.id.btnThree:
                buildValue("3");//store digit and display string being built
                break;
            case R.id.btnAddition:
                setOperation("+");// operation is addition
                break;
            case R.id.btnSign:
                sign();//execute change sign function
                break;
            case R.id.btnZero:
                buildValue("0");//store digit and display string being built
                break;
            case R.id.btnPoint:
                buildValue(".");//store decimal point and display string being built
                setPoint(true);
                break;
            case R.id.btnEquals:
                equals(getOperation());//call equals function with stored operation
                break;
            case R.id.btnPi:
                buildValue(Float.valueOf((float) (PI)).toString());//display and store Pi
                break;
            case R.id.btnEuler:
                buildValue(Float.valueOf((float) (E)).toString());//display and store e
                break;
            case R.id.btnRecip:
                equals("recip");//unary reciprocation function
                break;
            case R.id.btnNRt:
                setOperation("n√");//operation in nth root
                break;
            case R.id.btnSqrRt:
                equals("sqrRt");//unary square root function
                break;
            case R.id.btnEulerPow:
                equals("e^x");//unary e to the x function
                break;
            case R.id.btnLn:
                equals("ln");//unary natural log function
                break;
            case R.id.btnLog:
                equals("log");//unary lag base 10 function
                break;
            case R.id.btnPerCent:
                perCent();//execute per cent function
                break;
            case R.id.btnMemSet:
                setMem(getResult());//set memory from result view
                break;
            case R.id.btnMemRec:
                setInput(getMem());//put memory into input view
                break;
            case R.id.btnFact:
                factoral(getInput());//execute factoral function
                break;
            case R.id.btnSin:
                sin(getInput());//execute sin function
                break;
            case R.id.btnCos:
                cos(getInput());//execute cos function
                break;
            case R.id.btnTan:
                tan(getInput());//execute tan function
                break;
            default://if an operation has not been entered, display text
                Toast.makeText(getApplicationContext(), "Please input an operation.", Toast.LENGTH_SHORT).show();
        }
    }

    public void setInput(Float setNum) {
        tvInput.setText(setNum + "");//sets input TextView to number sent in
    }

    //sets input TextView to String sent in
    public void setInput(String setVal) {
        tvInput.setText(setVal);
    }

    //returns text in input TextView
    public String getInput() {
        return tvInput.getText().toString();
    }

    //sets result TextView to number sent in
    public void setResult(Float conclusion) {
        tvResult.setText(conclusion.toString());
    }

    //sets result TextView to String sent in
    public void setResult(String inStr) {
        tvResult.setText(inStr);
    }

    //returns text in result TextView
    public String getResult() {
        return tvResult.getText().toString();
    }

    //sets the value of the first operand to number sent in
    public void setValueOne(Float numIn) {
        setPoint(false);
        valueOne = numIn;
    }

    //sets the value of the first operand to String sent in
    public void setValueOne(String txtIn) {
        setPoint(false);
        valueOne = Float.parseFloat(txtIn);
    }

    //returns first operand as a Float
    public Float getValueOne() {
        return valueOne;
    }

    //sets the value of the second operand to number sent in
    public void setValueTwo(Float numIn) {
        valueTwo = numIn;
    }

    //sets the value of the second operand to String sent in
    public void setValueTwo(String txtIn) {
        valueTwo = Float.parseFloat(txtIn);
    }

    //returns second operand as a Float
    public Float getValueTwo() {
        return valueTwo;
    }

    //sets whether or not a decimal point is in use in input. If so, this is used to disallow a second.
    public void setPoint(boolean isUsed) {
        point = isUsed;
    }

    //used to determine state of decimal point
    public boolean getPoint() {
        return point;
    }

    //used to set a value in memory
    public void setMem(String memory) {
        this.memory = memory;
    }

    //used to return value from memory
    public String getMem() {
        return memory;
    }

    //builds input string and makes sure that no empty strings or valueless zeros are passed in
    public void setValueBuild(String inStr) {
        if (inStr.isEmpty() || inStr.length() == 1 && Float.parseFloat(inStr) == 0) {
            inStr = "";
        }
        valueBulid = inStr;
    }

    //returns value of input string
    public String getValueBulid() {
        return valueBulid;
    }

    //sets the operation variable given certain conditions
    public void setOperation(String symbol) {
        if (!operation.isEmpty()) {// if the operation variable is already loaded, do not let another operation in.
            Toast.makeText(getApplicationContext(), "Only one opperation at a time.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getInput().equals("") && getResult().equals("")) {//if both input and output are empty, there is nothing to operate on.
            Toast.makeText(getApplicationContext(), "Please input a number.", Toast.LENGTH_SHORT).show();
        } else if (getInput().equals("")) {//if input is empty, the operation must be on the value in the result field.
            setValueOne(getResult());
            setValueBuild(getResult());
        } else {// otherwise set the first operand to input.
            setValueOne(getValueBulid());
        }
        operation = symbol;//store the operation to be done
        setResult(getValueBulid() + symbol);//display it in result
        setValueBuild("");//clear input
    }

    //fetches value in operation
    public String getOperation() {
        return operation;
    }

    // clears operands and TextViews
    private void clear() {
        setValueOne((Float) null);
        setValueTwo((Float) null);
        setValueBuild("");
        setInput("");
        setResult("");
    }

    //changes the sign of the input value
    private void sign() {
        Float valueNum = Float.parseFloat(tvInput.getText().toString());
        valueNum *= -1;
        setInput(valueNum);//redisplays it to the input field
    }

    //stores the value being set by button presses
    private void buildValue(String digit) {
        if (!digit.equals(".") || !getPoint()) {// this disallows a duplicate decimal point
            setValueBuild(getValueBulid() + digit);
            setInput(getValueBulid());
        }
    }

    //uses Math the raise a number to a power
    private void power(Float first, Float second) {
        setResult((float) (pow(first, second)));
    }

    //divides the first number by the second
    private void divide(Float first, Float second) {
        setResult(first / second);

    }

    //multiplies the two numbers
    private void multiply(Float first, Float second) {
        setResult(first * second);
    }

    //subtracts the second number from the first
    private void subtract(Float first, Float second) {
        setResult(first - second);
    }

    //adds the two numbers
    private void add(Float first, Float second) {
        setResult(first + second);
    }

    //returns the multiplicative inverse of the number
    private void recip(Float input) {
        setResult(1 / input);
    }

    //nth root: raose the first number to the inverse of the second
    private void nRt(Float first, Float second) {
        setResult((float) pow(first, 1 / second));
    }

    //uses Math to take the square root of a number (positve root returned)
    private void sqrRt(Float input) {
        setResult((float) sqrt(input));
    }

    //raise e to given number
    private void ex(Float input) {
        setResult((float) exp(input));
    }

    //takes log base e of a number
    private void ln(Float input) {
        setResult((float) Math.log(input));
    }

    //takes log base 10 of a number
    private void log(Float input) {
        setResult((float) Math.log(input));
    }

    //divides input by 100 and returns that to input
    private void perCent() {
        setValueBuild(Float.valueOf(Float.parseFloat(getValueBulid()) / 100).toString());
        setInput(getValueBulid());
    }

    //factoral: defined only on whole numbers
    private void factoral(String input) {
        int base = (int) Float.parseFloat(input);
        int result = 1;
        if (base < 0) {//send message if input in ngative
            Toast.makeText(getApplicationContext(), "Factoral not defined on negative numbers.", Toast.LENGTH_SHORT).show();
            setValueBuild("");
            setInput("");
        } else if (base > 0) {//perform operation if greater that zero
            for (int i = base; i > 0; i--) {
                result *= i;
            }
            setResult((Float) (float) result);
        } else {//0! is defined as 1
            setResult(1);
        }
        setValueBuild("");//reset stored value and input TextView
        setInput("");
    }

    //uses Math.sin to return the sine of an input
    public void sin(String input) {
        setResult((Float) (float) toDegrees(Math.sin(toRadians(Float.parseFloat(input)))));
    }

    //ditto for cosine
    public void cos(String input) {
        setResult((Float) (float) toDegrees(Math.cos(toRadians(Float.parseFloat(input)))));
    }

    //ditto for tangent
    public void tan(String input) {
        setResult((Float) (float) toDegrees(Math.tan(toRadians(Float.parseFloat(input)))));
    }

    //this allows the input field to be backspaced
    private void back() {
        String segment = getValueBulid();//get input field
        if (segment.length() == 1 || segment.isEmpty()) {//if it is empty or nearly empty
            setInput("");//return empty String to input
            setValueBuild("");//and clear the dtored vale
        } else {//otherwise
            segment = segment.substring(0, segment.length() - 1);//cut the last character off
            setInput(segment);//return truncated String to input
            setValueBuild(segment);//and stored value
        }
    }

    //performs operations on stored values based on stored operation
    private void equals(String task) {//for binary operations
        setValueTwo(getValueBulid());//sets valueTwo, as valueOne has been set by setOperation
        setInput("");//clear input field and stored value String
        setValueBuild("");
        switch (task) {//call funtions based on operation
            case "^":
                power(getValueOne(), getValueTwo());
                break;
            case "/":
                divide(getValueOne(), getValueTwo());
                break;
            case "*":
                multiply(getValueOne(), getValueTwo());
                break;
            case "-":
                subtract(getValueOne(), getValueTwo());
                break;
            case "+":
                add(getValueOne(), getValueTwo());
                break;
            case "recip"://unary operation
                recip(getValueTwo());
                break;
            case "n√":
                nRt(getValueOne(), getValueTwo());
                break;
            case "sqrRt"://unary operation
                sqrRt(getValueTwo());
                break;
            case "e^x"://unary operation
                ex(getValueTwo());
                break;
            case "ln"://unary operation
                ln(getValueTwo());
                break;
            case "log"://unary operation
                log(getValueTwo());
                break;
        }
    }
}
