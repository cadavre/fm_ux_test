
package pro.jazzy.frankymobile.ux.tests;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Franky extends Activity {

    Vibrator vibrator;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_franky);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        final CircleView cvLeftSmall = (CircleView) findViewById(R.id.circle_left_small);
        final CircleView cvLeftBig = (CircleView) findViewById(R.id.circle_left_big);

        final CircleView cvRightSmall = (CircleView) findViewById(R.id.circle_right_small);
        final CircleView cvRightBig = (CircleView) findViewById(R.id.circle_right_big);

        cvLeftSmall.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                            android.R.anim.fade_in);
                    animFadeIn.setDuration(60);
                    animFadeIn.setFillAfter(true);
                    vibrator.vibrate(20);
                    cvLeftBig.startAnimation(animFadeIn);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                            android.R.anim.fade_out);
                    animFadeOut.setDuration(1200);
                    animFadeOut.setFillAfter(true);
                    cvLeftBig.startAnimation(animFadeOut);
                }
                return true;

            }
        });

        cvRightSmall.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                            android.R.anim.fade_in);
                    animFadeIn.setDuration(60);
                    animFadeIn.setFillAfter(true);
                    vibrator.vibrate(20);
                    cvRightBig.startAnimation(animFadeIn);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                            android.R.anim.fade_out);
                    animFadeOut.setDuration(1200);
                    animFadeOut.setFillAfter(true);
                    cvRightBig.startAnimation(animFadeOut);
                }
                return true;

            }
        });

        cvLeftBig.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.d("test", "down");
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_franky, menu);
        return true;
    }
}
