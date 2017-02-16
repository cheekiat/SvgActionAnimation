package cheekiat.svgactionanimation;

import android.os.Build;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button mPlay, mStar;
    boolean isPlay = false;
    boolean isStart = false;
    AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
    ImageView mSvgPlay, mSvgStart;
    AnimatedVectorDrawableCompat animVector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStar = (Button) findViewById(R.id.run);
        mPlay = (Button) findViewById(R.id.play);

        mSvgPlay = (ImageView) findViewById(R.id.svg_play);
        mSvgStart = (ImageView) findViewById(R.id.svg_start);

        animVector = AnimatedVectorDrawableCompat.create(
                getApplication(), R.drawable.v_heard_animation
        );

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {


            mPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isPlay) {
                        animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                                getApplication(), R.drawable.v_youtube_stop_animation
                        );
                        mSvgPlay.setImageDrawable(animatedVectorDrawableCompat);
                        if (animatedVectorDrawableCompat != null) {
                            animatedVectorDrawableCompat.start();
                        }
                        mPlay.setText("Play");
                    } else {
                        animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                                getApplication(), R.drawable.v_youtube_play_animation
                        );
                        mSvgPlay.setImageDrawable(animatedVectorDrawableCompat);
                        if (animatedVectorDrawableCompat != null) {
                            animatedVectorDrawableCompat.start();
                        }
                        mPlay.setText("Stop");
                    }

                    isPlay = !isPlay;
                }
            });

            mStar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mSvgStart.setImageDrawable(animVector);
                    if (animVector != null) {
                        if (isStart) {
                            animVector.stop();
                            mStar.setText("Run");
                        } else {
                            animVector.start();
                            mStar.setText("Stop");
                        }
                    }
                    isStart = !isStart;
                }
            });
        }
    }
}
