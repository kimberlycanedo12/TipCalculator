package com.example.kimberlycanedo.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText mEtBill;
    private EditText mEtNumberOfPeople;
    private TextView seekNum;
    private SeekBar seekBar;
    private TextView tpperson;
    private TextView Tvper;
    private TextView result1;
    private TextView tipPerPersonResult;
    private TextView totalPersonResult;
    Double perc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tvper = (TextView)findViewById(R.id.kim);
        double pes;
        mEtBill = (EditText) findViewById(R.id.bill);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        mEtNumberOfPeople = (EditText) findViewById(R.id.numOfPeople);

        tipPerPersonResult = (TextView) findViewById(R.id.tpperson);
        totalPersonResult = (TextView) findViewById(R.id.totalPerPerson);


        mEtBill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
            calculate();

            }
        });


        mEtNumberOfPeople.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
            calculate();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                perc=(double)i;
                Tvper.setText(perc+"%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            calculate();

            }
        });
    }



    public void calculate() {


        try {
            Double tipPer, totalTip;
            Double pes;

            Double Bill = Double.parseDouble(mEtBill.getText().toString());
            int people = Integer.parseInt(mEtNumberOfPeople.getText().toString());


            //tipPer = Bill / (double) people;
            pes = perc / 100;
            tipPer = (Bill / people) * pes;
            totalTip = (Bill / people) + tipPer;

            tipPerPersonResult.setText(tipPer + "");
            totalPersonResult.setText(totalTip + "");
        }
        catch(Exception s){
            tipPerPersonResult.setText("");
            totalPersonResult.setText("");
        }
    }
}



