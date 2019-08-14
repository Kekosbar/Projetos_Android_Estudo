package com.example.root.intentfilter;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class Tela1 extends Activity{

    static final int PICK_CONTACT_REQUEST = 1;  // The request code
    private TextView txtName, txtNumber;

    @Override
    protected void onCreate(Bundle saveInstanceSatate){
        super.onCreate(saveInstanceSatate);
        setContentView(R.layout.tela1);

        txtName = (TextView) findViewById(R.id.txtName);
        txtNumber= (TextView) findViewById(R.id.txtNumber);
    }

    public void voltar(View v){
        Intent intent = new Intent();
        setResult(PICK_CONTACT_REQUEST, intent);
        finish();
    }

    public void abrirContatos(View v){
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};
                Cursor cursor = getContentResolver()
                        .query(uri, projection, null, null, null);
                cursor.moveToFirst();
                // Retrieve the phone number from the NUMBER column
                int indexNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                int indexName = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);

                String number = cursor.getString(indexNumber);
                String name = cursor.getString(indexName);
                txtNumber.setText(number);
                txtName.setText(name);
                // Do something with the contact here (bigger example below)
            }
        }
    }

}
