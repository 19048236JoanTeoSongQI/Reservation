package sg.edu.rp.c346.id19048236.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    EditText name,num,pax;
    CheckBox smoke,noSmoke;
    Button confirm,reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);
        name=findViewById(R.id.custName);
        num=findViewById(R.id.custnum);
        pax=findViewById(R.id.numPax);
        smoke=findViewById(R.id.smoking);
        noSmoke=findViewById(R.id.nonSmoke);
        confirm=findViewById(R.id.confirm);
        reset=findViewById(R.id.reset);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}