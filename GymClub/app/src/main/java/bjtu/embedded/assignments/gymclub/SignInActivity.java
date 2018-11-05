package bjtu.embedded.assignments.gymclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    private EditText loggin;
    private EditText password;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        loggin = (EditText)findViewById(R.id.signin_loggin);
        password = (EditText)findViewById(R.id.signin_password);
        confirm = (Button)findViewById(R.id.signin_confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean test = testConnection();
                if (test == true) {
                    Intent i = new Intent(SignInActivity.this, DashBoardActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }
        });
    }

    private boolean testConnection() {
        // verify the loggin and password
        return true;
    }
}
