package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
     private Button mButtonlogin;
    EditText nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nombre=(EditText) findViewById(R.id.edit);
        mButtonlogin = (Button) findViewById(R.id.botonlogin);




        mButtonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = nombre.getText().toString();
                Intent intent=new Intent(LoginActivity.this,PreguntaActivity.class);
                if(user.trim().length()>0) {

                    intent.putExtra("nombre",user);
                    startActivity(intent);
            }else{
                    Toast.makeText(LoginActivity.this,
                            R.string.incorrect_toast,
                            Toast.LENGTH_SHORT).show();

                }

            }








});

}
        }
