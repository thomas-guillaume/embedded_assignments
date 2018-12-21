package bjtu.embedded.assignments.gymclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    private EditText email;
    private EditText password;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = (EditText)findViewById(R.id.signin_email);
        password = (EditText)findViewById(R.id.signin_password);
        confirm = (Button)findViewById(R.id.signin_confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (testSignIn()) {
                    Intent i = new Intent(SignInActivity.this, DashBoardActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }
        });
    }

    private boolean testSignIn() {
        // verify the email and password
        String emailstr = email.getText().toString();
        String passstr = password.getText().toString();

        String password = helper.searchPassword(emailstr);

        if(!passstr.equals(password))
        {
            Toast error = Toast.makeText(SignInActivity.this, "Username & Password don't match !", Toast.LENGTH_LONG);
            error.show();

            return false;
        }

        return true;
    }
}
