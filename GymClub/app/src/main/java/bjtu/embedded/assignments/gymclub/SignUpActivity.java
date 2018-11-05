package bjtu.embedded.assignments.gymclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private EditText password_bis;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = (EditText)findViewById(R.id.signup_email);
        password = (EditText)findViewById(R.id.signup_password);
        password_bis = (EditText)findViewById(R.id.signup_password_bis);
        confirm = (Button)findViewById(R.id.signup_confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean test = testConnection();
                if (test == true) {
                    Intent i = new Intent(SignUpActivity.this, DashBoardActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }
        });
    }

    private boolean testConnection() {
        // verify the email and passwords
        return true;
    }
}
