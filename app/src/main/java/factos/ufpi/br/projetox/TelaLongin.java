package factos.ufpi.br.projetox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelaLongin extends AppCompatActivity {

    private EditText emailEdittext;
    private EditText passEdittext;
    private Toolbar myToolbar;
    private BottomNavigationView myBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("Perfil");
        setSupportActionBar(myToolbar);

        emailEdittext = (EditText) findViewById(R.id.username);
        passEdittext = (EditText) findViewById(R.id.password);

        myBottomNav = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        myBottomNav.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent it = new Intent(TelaLongin.this,TelaHome.class);
                        startActivity(it);
                        break;
                    case R.id.ic_user:
                        break;
                    case R.id.ic_Top10:
                        break;
                }
                return true;
            }
        });

    }

    public void checkLogin(View view){

        final String email = emailEdittext.getText().toString();
        if(!isValidEmail(email)){
            emailEdittext.setError("Email Invalido");
        }

        final String pass = passEdittext.getText().toString();
        if(isValidPassword(pass)){
            passEdittext.setError("A senha tem que ter mais de 4 caracteres");
        }

        if(isValidEmail(email) && isValidPassword(pass)){
            Intent intent = new Intent(TelaLongin.this,TelaUsuario.class);
            startActivity(intent);
        }

    }

    // validação do email
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    // validação da senha
    private boolean isValidPassword(String pass){
        if (pass != null && pass.length() >= 4) {
            return true;
        }
        return false;
    }


    public void TelaEsqueceuSenha(View view){
        Intent intent = new Intent(TelaLongin.this,TelaEsqueceuSenha.class);
        startActivity(intent);
    }

    public void telaCriarConta(View view){
        Intent intent = new Intent(TelaLongin.this,TelaCriarConta.class);
        startActivity(intent);
    }
}
