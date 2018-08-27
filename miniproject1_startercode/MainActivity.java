package example.basic.com.exampletipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements TextWatcher, SeekBar.OnSeekBarChangeListener{

   //declare your variables for the widgets
   private EditText editTextBillAmount;
   private TextView textViewBillAmount;

   //declare the variables for the calculations
   private double billAmount = 0.0;
   private double percent = .15;

   //set the number formats to be used for the $ amounts , and % amounts
   private static final NumberFormat currencyFormat =
           NumberFormat.getCurrencyInstance();
   private static final NumberFormat percentFormat =
           NumberFormat.getPercentInstance();

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       //add Listeners to Widgets
       editTextBillAmount = (EditText)findViewById(R.id.editText_BillAmount);//uncomment this line
       editTextBillAmount.addTextChangedListener((TextWatcher) this);//uncomment this line


       textViewBillAmount = (TextView)findViewById(R.id.textView_BillAmount);
   }

   @Override
   public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

   }

   /*
   Note:   int i, int i1, and int i2
           represent start, before, count respectively
           The charSequence is converted to a String and parsed to a double for you
    */
   @Override
   public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
       Log.d("MainActivity", "inside onTextChanged method: charSequence= "+charSequence);
       //surround risky calculations with try catch (what if billAmount is 0 ?
       //charSequence is converted to a String and parsed to a double for you
       billAmount = Double.parseDouble(charSequence.toString()) / 100; Log.d("MainActivity", "Bill Amount = "+billAmount);
       //setText on the textView
       textViewBillAmount.setText(currencyFormat.format(billAmount));
       //perform tip and total calculation and update UI by calling calculate
       calculate();//uncomment this line
   }

   @Override
   public void afterTextChanged(Editable editable) {

   }


   @Override
   public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
       percent = progress / 100; //calculate percent based on seeker value
       calculate();
   }

   @Override
   public void onStartTrackingTouch(SeekBar seekBar) {

   }

   @Override
   public void onStopTrackingTouch(SeekBar seekBar) {

   }

   // calculate and display tip and total amounts
   private void calculate() {
       Log.d("MainActivity", "inside calculate method");
       //uncomment below
       /*
       // format percent and display in percentTextView
      textViewPercent.setText(percentFormat.format(percent));

       // calculate the tip and total
       double tip = billAmount * percent;
      //use the tip example to do the same for the Total

       // display tip and total formatted as currency
       //user currencyFormat instead of percentFormat to set the textViewTip
       // tipTextView.setText(currencyFormat.format(tip));
       //use the tip example to do the same for the Total
       */
   }
}
