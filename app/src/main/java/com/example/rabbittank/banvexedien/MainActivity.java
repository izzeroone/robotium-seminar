package com.example.rabbittank.banvexedien;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TimePicker dpPicker;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        setDpPicker((TimePicker) findViewById(R.id.datePicker));
        setTvResult((TextView) findViewById(R.id.textView));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setLoaiVe(dpPicker.getHour(), dpPicker.getMinute());
        }
        getDpPicker().setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                setLoaiVe(hourOfDay, minute);
            }
        });

    }

    private void setLoaiVe(int hourOfDay, int minute){
        //Truong hop khong hop le
        int minuteOfDay = hourOfDay * 60 + minute;
        if(minuteOfDay >= 0 && minuteOfDay <= 3 * 60 + 59){
            getTvResult().setText("Khong hop le");
            return;
        }

        if(minuteOfDay >= 4 * 60 && minuteOfDay <= 9 * 60 + 29){
            getTvResult().setText("Ve thuong");
            return;
        }

        if(minuteOfDay >= 9 * 60 + 30 && minuteOfDay <= 16 * 60){
            getTvResult().setText("Ve tiet kiem");
            return;
        }

        if(minuteOfDay >= 16 * 60 + 1 && minuteOfDay <= 19 * 60 + 30){
            getTvResult().setText("Ve thuong");
            return;
        }

        if(minuteOfDay >= 19 * 60 + 31 && minuteOfDay <= 22 * 60 + 59){
            getTvResult().setText("Ve tiet kiem");
            return;
        }

        if(minuteOfDay >= 23 * 60 && minuteOfDay <= 23 * 60 + 59){
            getTvResult().setText("Khong hop le");
            return;
        }

        getTvResult().setText("Gio khong ton tai");
    }

    public TimePicker getDpPicker() {
        return dpPicker;
    }

    public void setDpPicker(TimePicker dpPicker) {
        this.dpPicker = dpPicker;
    }

    public TextView getTvResult() {
        return tvResult;
    }

    public void setTvResult(TextView tvResult) {
        this.tvResult = tvResult;
    }
}
