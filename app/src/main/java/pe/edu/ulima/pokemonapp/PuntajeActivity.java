package pe.edu.ulima.pokemonapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PuntajeActivity extends AppCompatActivity {
      TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);
        text=(TextView)findViewById(R.id.txtPuntaje) ;


        Bundle bundlesito=getIntent().getExtras();

        int puntaje= bundlesito.getInt("puntaje");
        text.setText(String.valueOf(puntaje));

    }
}
