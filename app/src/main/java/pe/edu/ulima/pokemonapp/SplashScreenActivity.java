package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {
        ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imagen=(ImageView)findViewById(R.id.logo);
        new CountDownTimer(3000,1000){
            @Override
            public void onTick(long millisUntilFinished){}

            @Override
            public void onFinish(){
                //set the new Content of your activity

                Intent intentlogin=new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intentlogin);
            }
        }.start();



    }
}
