package view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lugaluga.R;
import com.google.android.material.textfield.TextInputLayout;

public class loginActivity extends AppCompatActivity {

    private Button btnLogin;

    private TextInputLayout inputEmail,inputSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

            inputEmail =findViewById(R.id.outlinedTextField);
            inputSenha = findViewById(R.id.outlinedTextField2);

            btnLogin = findViewById(R.id.btnL);

        Intent intent = new Intent(this, MainActivity.class);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (validaEmail()){
                        startActivity(intent);
                    }
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