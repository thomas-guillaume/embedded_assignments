package bjtu.embedded.assignments.gymclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpSignInActivity extends AppCompatActivity {

    private Button sign_up_btn;
    private Button sign_in_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_sign_in);

        sign_up_btn = (Button)findViewById(R.id.sign_up_btn);
        sign_in_btn = (Button)findViewById(R.id.sign_in_btn);

        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpSignInActivity.this, SignUpActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        });

        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpSignInActivity.this, SignInActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        });
    }
}
