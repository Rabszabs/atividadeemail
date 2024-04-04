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
    Button btnEnviar = (Button) findViewById(R.id.btnEnviar); //obtem dados do botao atraves do método findbyview

    //Definição da ação do click do botão
    btnEnviar.setOnClickListener(new View.OnClickListener() { //quando clicar
        @Override
        public void onClick(View v) { //quando o botão for clicado será ativado o método OnClick

            //obtendo dados digitados pelo usuários
            EditText etEmail = (EditText)
        findViewById(R.id.etEmail); //obtem o id do Email
            String email = etEmail.getText().toString(); //Obtem o valor digitado pelo usuário

            EditText etAssunto = (EditText)
        findViewById(R.id.etAssunto); //obtem o idAssunto (id do assunto)
            String assunto = etAssunto.getText().toString(); //Obtem o valor digitado pelo usuário

            EditText etText = (EditText)
        findViewById(R.id.etText); //obtem o idtext (id do texto)
            String texto = etText.getText().toString(); //Obtem o valor digitado pelo usuário

            Intent i = new Intent(Intent.ACTION_SENDTO); //realiza um intent implicito para direcionar o usuário a um app capaz de interpretar a ação pedida

            i.setData(Uri.parse("mailto:")); //indica que existe interesse apenas nos apps que enviam e recebem emails

            String[] emails = new String[]{email}; //prenchimento do intent com os dados para enviar pro email
            i.putExtra(Intent.EXTRA_EMAIL, emails); //email destinatario
            i.putExtra(Intent.EXTRA_SUBJECT, assunto); //assunto do email
            i.putExtra(Intent.EXTRA_TEXT, texto); //texto do email

            try { //tentativa de realizar o intent
                startActivity(Intent.createChooser(i, "Escolha o APP")); //menu em que aparecem as opções de apps que são capazes de enviar o email
            }
            catch (ActivityNotFoundException e){ //caso a tentativa falhe
                Toast.makeText(MainActivity.this, "Não há nenhum app que posso realizar essa operação", Toast.LENGTH_LONG).show(); //caso não exista nenhum app capaz de realizar a ação é exibida a mensagem entre aspas
            }

        }
    });}}




















