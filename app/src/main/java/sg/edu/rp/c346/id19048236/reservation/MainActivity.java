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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    EditText name,num,pax;
    CheckBox smoke;
    Button confirm,reset;
    TextView confirmation, details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        name = findViewById(R.id.custName);
        num = findViewById(R.id.custnum);
        pax = findViewById(R.id.numPax);
        smoke = findViewById(R.id.smoking);
        confirm = findViewById(R.id.confirm);
        reset = findViewById(R.id.reset);
        confirmation = findViewById(R.id.textViewConfirmation);
        details = findViewById(R.id.textViewDetails);

        dp.updateDate(2020, 6, 1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if (hourOfDay < 20) {
                    view.setCurrentHour(20);
                } else if (hourOfDay > 20) {
                    view.setCurrentHour(20);
                }
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim().length()!=0 && pax.getText().toString().trim().length()!=0 && num.getText().toString().trim().length()!=0){
                    confirmation.setText("Confirmation");
                    String dName=String.format("Name: %s\n",name.getText().toString());
                    String dPax=String.format("Pax: %s\n",pax.getText().toString());
                    String dPhone=String.format("Mobile no.: %s\n",num.getText().toString());
                    String dSmoke;

                    if(smoke.isChecked()){
                        dSmoke=String.format("Table area is in Smoking area.\n");

                    }else{
                        dSmoke=String.format("Table area is in Non-smoking area");
                    }
                    int day=dp.getDayOfMonth();
                    int month=dp.getMonth()+1;
                    int year=dp.getYear();

                    String dDate= String.format("Date booked: %d/ %d/ %d",day,month,year);
                    String dTime=String.format("Time booked: %d: %d",tp.getCurrentHour(),tp.getCurrentMinute());

                    details.setText(dName+dPax+dPhone+dSmoke+dDate+dTime);
                }else{
                    Toast.makeText(MainActivity.this,"Please fill in all the fields",Toast.LENGTH_SHORT).show();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                pax.setText("");
                num.setText("");
                smoke.setChecked(false);
                dp.updateDate(2020,6,1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });

    }
}