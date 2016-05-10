package kr.hs.emirim.kokopink1.reservation;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.*;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button butStart,butDone;
    RadioButton radioDate,radioTime;
    CalendarView calView;
    TimePicker timeP;
    TextView textResult;
    // 참조 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //임플레이션 : 클래스를 패키지에서 찾고 주기억장치에 올려주는것
        //레이아웃 화면 뜸!

        chrono=(Chronometer)findViewById(R.id.chrono);
        // findViewById 반환형 : View -> 강제 형 변환!
        butStart=(Button)findViewById(R.id.but_start);
        butDone=(Button)findViewById(R.id.but_done);
        radioDate=(RadioButton)findViewById(R.id.radio_date);
        radioTime=(RadioButton)findViewById(R.id.radio_time);
        calView=(CalendarView)findViewById(R.id.calender);
        timeP=(TimePicker)findViewById(R.id.time_pick);
        textResult=(TextView)findViewById(R.id.text_result);

        timeP.setVisibility(View.INVISIBLE); //보이지 않게
        calView.setVisibility(View.INVISIBLE);

        radioDate.setOnClickListener(new View.OnClickListener() {  //()안에 객체생성한 상속값
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.VISIBLE);
                timeP.setVisibility(View.INVISIBLE);
            }
        });

        radioTime.setOnClickListener(new View.OnClickListener() {  //()안에 객체생성한 상속값
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.INVISIBLE);
                timeP.setVisibility(View.VISIBLE);
            }
        });

        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime()); //기본적으로 시스템의 시간 사용할 때 명시
                chrono.start(); //타이머 시간 설정!
                chrono.setTextColor(Color.RED);
            }
        });

        butDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                Calendar cal=Calendar.getInstance(); //Calendar 추상클래스의 겟인스턴스를 이용해 값구하기!@!@
                cal.setTimeInMillis(calView.getDate());
                int year=cal.get(Calendar.YEAR); //년도 반환
                int month=cal.get(Calendar.MONTH)+1;
                int date=cal.get(Calendar.DATE);

                //int hour=timeP.getHour();
                //int minute=timeP.getMinute();

                String dateAndTime=year+"년 "+month+"분 "+date+"일 ";
                textResult.setText(dateAndTime);

            }
        });

    }
}
/*     핸들러 클래스 -  익명 클래스 (이름없이 클래스를 구현 + 객체생성)
            *
            * (EventListener (감시자))
       - 날짜 설정
       - 시간 설정 (Event Source) */