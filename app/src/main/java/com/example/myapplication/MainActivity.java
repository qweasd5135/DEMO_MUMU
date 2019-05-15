package com.example.myapplication;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
     ImageView ball;
    private int alertId;
    private SoundPool soundPool;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ball = findViewById(R.id.imageView1);


        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);
        alertId = soundPool.load(this, R.raw.sound1, 1);

                //soundPool.play(alertId, 1.0F, 1.0F, 0, 0, 1.0F);



    }


    @Override
    protected void onResume(){
        super.onResume();
        ball.setOnTouchListener(imgListener);//觸控時監聽
    }


    private View.OnTouchListener imgListener = new View.OnTouchListener() {


        @Override
        public boolean onTouch(View v, MotionEvent event) {

                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) v.getLayoutParams();

                switch(event.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        params.topMargin = (int)event.getRawY() - v.getHeight();
                        params.leftMargin = (int)event.getRawX() - (v.getWidth()/2);
                        v.setLayoutParams(params);
                        break;


                    case MotionEvent.ACTION_UP:
                        params.topMargin = (int)event.getRawY() - v.getHeight();
                        params.leftMargin = (int)event.getRawX() - (v.getWidth()/2);
                        v.setLayoutParams(params);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        v.setLayoutParams(params);
                        break;
                }
                return true;
            }


        };


//    private void gettingXY(View v){
//        //得到的傳值View v再傳下去下一個class
//        int[] loc = new int[2];
//        int[] laterOfRunningClass; // 用來取得returnArray()回傳的陣列
//        imgUP.getLocationOnScreen(loc);
//        laterOfRunningClass = returnArray(loc, v);
//        Log.d("Img Up", laterOfRunningClass[0] + ", " + laterOfRunningClass[1] + ", " + laterOfRunningClass[2] + ", "
//                + laterOfRunningClass[3]);
//        //得到的樣子會是(x, y , x的終寬, y的終高)
//        imgDown.getLocationOnScreen(loc);
//        laterOfRunningClass = returnArray(loc, v);
//        Log.d("Img Down", laterOfRunningClass[0] + ", " + laterOfRunningClass[1] + ", " + laterOfRunningClass[2] + ", "
//                + laterOfRunningClass[3]);
//        imgLeft.getLocationOnScreen(loc);
//        laterOfRunningClass = returnArray(loc, v);
//        Log.d("Img Left", laterOfRunningClass[0] + ", " + laterOfRunningClass[1] + ", " + laterOfRunningClass[2] + ", "
//                + laterOfRunningClass[3]);
//        imgLeft.getLocationOnScreen(loc);
//        laterOfRunningClass = returnArray(loc, v);
//        Log.d("Img Right", laterOfRunningClass[0] + ", " + laterOfRunningClass[1] + ", " + laterOfRunningClass[2] + ", "
//                + laterOfRunningClass[3]);
//    }
//
//    /*
//            2019-05-13 02:11:25.560 14003-14003/com.example.myapplication D/Img Up: 409, 167, 672, 430
//                    417, 123,680,386
//            2019-05-13 02:11:25.561 14003-14003/com.example.myapplication D/Img Down: 409, 1586, 672, 1849
//                    415, 1600,678,1863
//            2019-05-13 02:11:25.561 14003-14003/com.example.myapplication D/Img Left: 42, 787, 305, 1050
//                    48, 777,311,1040
//            2019-05-13 02:11:25.561 14003-14003/com.example.myapplication D/Img Right: 42, 787, 305, 1050
//                    ++770, 775,1033,1038
//
//
//            gettingXY() 以及 returnArray()都只是為了求上述的數值而已幹
//     */
//
//    private int[] returnArray(int[] loc, View v){
//        int[] got = new int[4];
//        got[0] = loc[0];
//        got[1] = loc[1];
//        got[2] = got[0] + v.getWidth();
//        got[3] = got[1] + v.getHeight();
//        return got;
//    }
}
