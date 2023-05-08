package com.example.contactus;
import com.example.contactus.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends Activity {

    private EditText editTextTitle, editTextMessage;
    private Button buttonSendEmail, buttonOpenWhatsAppPK, buttonOpenWhatsAppUS, buttonVisitGoodBooks, buttonVisitWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        editTextTitle = findViewById(R.id.editTextTextMultiLine);
        editTextMessage = findViewById(R.id.editTextTextMultiLine2);

        buttonSendEmail = findViewById(R.id.button);
        buttonSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String message = editTextMessage.getText().toString();
                sendEmail(title, message);
            }
        });

        buttonOpenWhatsAppPK = findViewById(R.id.button2);
        buttonOpenWhatsAppPK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWhatsApp("+923005200861");
            }
        });

        buttonOpenWhatsAppUS = findViewById(R.id.button3);
        buttonOpenWhatsAppUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWhatsApp("+1234567890");
            }
        });

        buttonVisitGoodBooks = findViewById(R.id.button4);
        buttonVisitGoodBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visitWebsite("https://www.goodbooks.com");
            }
        });

        buttonVisitWebsite = findViewById(R.id.button5);
        buttonVisitWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visitWebsite("https://www.github.com/alam-khawaja");
            }
        });
    }

    private void sendEmail(String title, String message) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "example@example.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    private void openWhatsApp(String phoneNumber) {
        String url = "https://api.whatsapp.com/send?phone=" + phoneNumber;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void visitWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
