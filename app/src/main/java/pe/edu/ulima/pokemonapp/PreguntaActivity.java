package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import pe.edu.ulima.pokemonapp.model.GestorPokemonApp;
import pe.edu.ulima.pokemonapp.model.Pregunta;

public class PreguntaActivity extends AppCompatActivity {

    TextView pregunta;
    TextView detalle;
    ImageButton mNextButton;
    ImageButton mValidarButton;
    EditText respuesta;
    ImageView imagen;
    private Pregunta mPregunta;
    List <Pregunta> preguntas  = GestorPokemonApp.getInstance().obtenerPreguntas();
    private int mCurrentIndex = 0;

    private int mpuntaje=0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
                mNextButton=(ImageButton)findViewById(R.id.boton_next);
                mValidarButton=(ImageButton)findViewById(R.id.boton_validar);
                pregunta=(TextView)findViewById(R.id.pregunta);
                detalle=(TextView)findViewById(R.id.glosa_texto);
                imagen=(ImageView)findViewById(R.id.imagenPokemon);
                respuesta=(EditText)findViewById(R.id.respuesta);
                pregunta.setText("Pregunta" + preguntas.get(mCurrentIndex).getId());
                detalle.setText( preguntas.get(mCurrentIndex).getPregunta());

        //se trae el usuario
            Bundle bundlesito=getIntent().getExtras();

            String usuario= bundlesito.getString("nombre");


        mValidarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String rpta=respuesta.getText().toString();
                if(rpta.equalsIgnoreCase(preguntas.get(mCurrentIndex).getRespuesta())){
                    Toast.makeText(PreguntaActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                            mpuntaje=mpuntaje+10;

                    imagen.setImageResource(preguntas.get(mCurrentIndex).getImagen());


                }else{
                    Toast.makeText(PreguntaActivity.this,
                            R.string.incorrectp_toast,
                            Toast.LENGTH_SHORT).show();


                }
            }
        });



        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex++;
                if(mCurrentIndex==preguntas.size()) {
                    Intent intent = new Intent(PreguntaActivity.this, PuntajeActivity.class);
                    intent.putExtra("puntaje",mpuntaje);
                    startActivity(intent);


                }else{
                    pregunta.setText("Pregunta" + preguntas.get(mCurrentIndex).getId());
                    detalle.setText( preguntas.get(mCurrentIndex).getPregunta());
                    respuesta.setText("");

                    imagen.setImageResource(R.drawable.pokeball);
                }



            }
        });


    }
}
