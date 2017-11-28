package com.example.user_j.project5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity
{
    private TextView txtResult;
    private RadioButton radBasketBall,radFootBall,radBaseBall;
    private RadioGroup radGroupBalls;
    private Spinner spnPrefer;
    String[] Balls = new String[] {"籃球","足球","棒球","其他"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //取得介面元件id
        txtResult = (TextView) findViewById(R.id.txtResult);
        radGroupBalls = (RadioGroup) findViewById(R.id.radGroupBalls);
        radBasketBall = (RadioButton) findViewById(R.id.radBasketBall);
        radFootBall = (RadioButton) findViewById(R.id.radFootBall);
        radBaseBall = (RadioButton) findViewById(R.id.radBaseBall);

        spnPrefer = (Spinner) findViewById(R.id.spnPrefer);
        ArrayAdapter<CharSequence> adapterBalls = ArrayAdapter.createFromResource(this,R.array.Balls,android.R.layout.simple_spinner_item);
        adapterBalls.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPrefer.setAdapter(adapterBalls);
        radGroupBalls.setOnCheckedChangeListener(radGroupBallsListener);
        spnPrefer.setOnItemSelectedListener(spnPreferListener);
    }
    //定義onCheckedChange方法
    private RadioGroup.OnCheckedChangeListener radGroupBallsListener = new RadioGroup.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup group,int checkedId)
        {
            int p = group.indexOfChild((RadioButton)findViewById(checkedId));
            int count = group.getChildCount();
            if(checkedId == R.id.radBasketBall)
            {
                txtResult.setText( count + "項球類中，最喜歡第 " + (p + 1) + "項" + radBaseBall.getText());
            }
            else if (checkedId == R.id.radFootBall)
            {
                txtResult.setText( count + " 項球類中，最喜歡第 " + (p + 1) + "項" + radFootBall.getText());
            }
            else if (checkedId == R.id.radBaseBall)
            {
                txtResult.setText(count + " 項球類中，最喜歡第 " + (p + 1) + "項" + radBaseBall.getText());
            }

        }
    };
    private Spinner.OnItemSelectedListener spnPreferListener = new Spinner.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view,int position,long id)
        {
            String sel = parent.getSelectedItem().toString();
            txtResult.setText(sel);
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {

        }
    };
}
