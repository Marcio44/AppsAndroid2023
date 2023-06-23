package devandroid.silva.AppListaCurso.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import devandroid.silva.AppListaCurso.R;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        comutarTelaSpalsh();
    }

    private void comutarTelaSpalsh() {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent callTelaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(callTelaPrincipal);
                    finish();
                }
            }, TIME_OUT_SPLASH );

    }
}