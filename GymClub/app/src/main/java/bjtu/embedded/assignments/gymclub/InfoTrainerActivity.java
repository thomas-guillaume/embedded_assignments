package bjtu.embedded.assignments.gymclub;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InfoTrainerActivity extends AppCompatActivity {

    private Button email;
    private Button phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_trainer);

        email = (Button)findViewById(R.id.email);
        phone = (Button)findViewById(R.id.phone);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.setType("message/rfc822");
                mailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{email.getText().toString()});
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                mailIntent.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(mailIntent, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(InfoTrainerActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(InfoTrainerActivity.this);
                builder.setTitle("What do you want to do ?")
                        .setPositiveButton("Phone call", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent callIntent = new Intent(Intent.ACTION_CALL);
                                callIntent.setData(Uri.parse("tel:" + phone.getText().toString()));

                                try {
                                    startActivity(callIntent);
                                } catch (android.content.ActivityNotFoundException ex) {
                                    Toast.makeText(InfoTrainerActivity.this,"Phone call failed, please try again later.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Sms", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                                smsIntent.setData(Uri.parse("smsto:"));
                                smsIntent.setType("vnd.android-dir/mms-sms");
                                smsIntent.putExtra("address"  , phone.getText().toString());
                                smsIntent.putExtra("sms_body"  , "Test ");

                                try {
                                    startActivity(smsIntent);
                                } catch (android.content.ActivityNotFoundException ex) {
                                    Toast.makeText(InfoTrainerActivity.this,"SMS failed, please try again later.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNeutralButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }
}
