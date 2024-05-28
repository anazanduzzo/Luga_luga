package view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lugaluga.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class loginActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnCadastrar;

    private TextInputLayout inputEmail,inputSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

            inputEmail =findViewById(R.id.outlinedTextField);
            inputSenha = findViewById(R.id.outlinedTextField2);

            inputEmail.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    Pattern pattern;
                    Matcher matcher;
                    String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                    pattern = Pattern.compile(EMAIL_PATTERN);
                    CharSequence cs = (CharSequence) s;
                    matcher = pattern.matcher(cs);
                    if (!(matcher.matches() == true)) {
                        inputEmail.setError("Invalid email");
                    } else {
                        inputEmail.setError("");
                    }
                }
            });

            btnLogin = findViewById(R.id.btnL);
            Intent intent = new Intent(this, MainActivity2.class);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (validaEmail()){
                        startActivity(intent);
                    }
                }
            });
            btnCadastrar = findViewById(R.id.btnL2);
            Intent intentCadastro = new Intent(this, CadastrarUsuarioActivity.class);
            btnCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intentCadastro);
                }
            });


    }

    public boolean validaEmail(){
        if (inputEmail.getEditText() != null && inputEmail.getEditText().getText().toString().equals("")){
            inputEmail.setError("informe o email");
            return false;
        }
        if (inputSenha.getEditText() != null && inputSenha.getEditText().getText().toString().equals("")){
            inputEmail.setError("informe a senha");
            return false;
        }

        return true;
    }

}