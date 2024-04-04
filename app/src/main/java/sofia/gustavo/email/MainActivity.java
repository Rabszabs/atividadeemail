package sofia.gustavo.email;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    Button btnEnviar = (Button) findViewById(R.id.btnEnviar); //obtem dadlos do botao
    //Definição da ação do click do botão
    btnEnviar.setOnClickListener(new View.OnClickListener() { //quando clicar...
        @Override
        public void onClick(View v) {

            //obtendo dados digitados pelo usuárioswdsd
            EditText etEmail = (EditText)
        findViewById(R.id.etEmail);
            String email = etEmail.getText().toString();

            EditText etAssunto = (EditText)
        findViewById(R.id.etAssunto);
            String assunto = etAssunto.getText().toString();

            EditText etText = (EditText)
        findViewById(R.id.etText);
            String texto = etText.getText().toString();

            Intent i = new Intent(Intent.ACTION_SENDTO);

            i.setData(Uri.parse("mailto:"));

            String[] emails = new String[]{email};
            i.putExtra(Intent.EXTRA_EMAIL, emails);
            i.putExtra(Intent.EXTRA_SUBJECT, assunto);
            i.putExtra(Intent.EXTRA_TEXT, texto);

            try {
                startActivity(Intent.createChooser(i, "Escolha o APP"));
            }
            catch (ActivityNotFoundException e){
                Toast.makeText(MainActivity.this, "Não há nenhum app que posso realizar essa operação", Toast.LENGTH_LONG).show();
            }

        }
    });}}




















