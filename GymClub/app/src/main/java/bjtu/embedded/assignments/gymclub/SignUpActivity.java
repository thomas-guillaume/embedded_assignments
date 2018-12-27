package bjtu.embedded.assignments.gymclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bjtu.embedded.assignments.gymclub.Model.DatabaseHelper;
import bjtu.embedded.assignments.gymclub.Model.Person;

public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    private EditText firstname;
    private EditText lastname;
    private EditText email;
    private EditText password;
    private EditText password_bis;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstname = (EditText)findViewById(R.id.first_name);
        lastname = (EditText)findViewById(R.id.last_name);
        email = (EditText)findViewById(R.id.signup_email);
        password = (EditText)findViewById(R.id.signup_password);
        password_bis = (EditText)findViewById(R.id.signup_password_bis);
        confirm = (Button)findViewById(R.id.signup_confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (testSignUp()) {
                    Intent i = new Intent(SignUpActivity.this, DashBoardActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }
        });
    }

    private boolean testSignUp() {
        // get input values
        String firstnamestr = firstname.getText().toString();
        String lastnamestr = lastname.getText().toString();
        String emailstr = email.getText().toString();
        String passstr = password.getText().toString();
        String passbisstr = password_bis.getText().toString();

        // Verify the input values
        if (firstnamestr == "" || lastnamestr == "" || emailstr == "" || passstr == "")
        {
            // Display an error
            Toast error = Toast.makeText(SignUpActivity.this, "Please fill all the information !", Toast.LENGTH_LONG);
            error.show();

            return false;
        }

        // Verify the email
        boolean result = helper.searchEmail(emailstr);
        if(result)
        {
            // Display an error
            Toast error = Toast.makeText(SignUpActivity.this, "Email already registered !", Toast.LENGTH_LONG);
            error.show();

            return false;
        } else {
            // Verify the passwords
            if(!passstr.equals(passbisstr))
            {
                // Display an error
                Toast error = Toast.makeText(SignUpActivity.this, "Passwords don't match !", Toast.LENGTH_LONG);
                error.show();

                return false;
            }
            else
            {
                //insert the details in DB:
                Person p = new Person();
                p.setFirstname(firstnamestr);
                p.setLastname(lastnamestr);
                p.setEmail(emailstr);
                p.setPassword(passstr);

                helper.insertPerson(p);
            }
        }

        return true;
    }
}
