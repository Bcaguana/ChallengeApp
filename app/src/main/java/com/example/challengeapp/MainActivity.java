package com.example.challengeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    RadioGroup rgGenderStatus;
    EditText txtName, txtEmail, txtPassword, txtRe;
    TextView invalidName, invalidEmail, invalidPassword, invalidMatch;
    Button btnRegister, btnSetImage;
    Spinner countrySpinner;
    CheckBox checkboxAgreement;
    Boolean agreement = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        rgGenderStatus = findViewById(R.id.rgGender);
        rgGenderStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioBtnMale:
                        Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBtnFemale:
                        Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBtnOther:
                        Toast.makeText(MainActivity.this, "Other", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        checkboxAgreement = findViewById(R.id.checkboxAgreement);
        checkboxAgreement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked)
                    agreement = true;
                else
                    agreement = false;
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (agreement)
                    validateRegistration();
                else
                    Toast.makeText(MainActivity.this, "Agree to the License", Toast.LENGTH_SHORT).show();
            }
        });
        btnSetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Set Image", Toast.LENGTH_SHORT).show();

            }
        });

        countrySpinner = findViewById(R.id.countrySpinner);
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, countrySpinner.getSelectedItem().toString() + " Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void initViews(){
        txtName = findViewById(R.id.editTxtName);
        txtEmail = findViewById(R.id.editTxtEmail);
        txtPassword = findViewById(R.id.editTxtPassword);
        txtRe = findViewById(R.id.editTxtReEnter);

        invalidName = findViewById(R.id.txtInvalidName);
        invalidEmail = findViewById(R.id.txtInvalidEmail);
        invalidPassword = findViewById(R.id.txtInvalidPassword);
        invalidMatch = findViewById(R.id.txtInvalidMatch);

        btnRegister = findViewById(R.id.btnRegister);
        btnSetImage = findViewById(R.id.btnPickImage);
    }

    public void validateRegistration() {
        invalidName.setVisibility(View.GONE);
        invalidEmail.setVisibility(View.GONE);
        invalidPassword.setVisibility(View.GONE);
        invalidMatch.setVisibility(View.GONE);
        System.out.println("still false");
        if (txtName.getText().toString().isEmpty()) {
            invalidName.setVisibility(View.VISIBLE);
            Log.d(TAG, "Name not valid");
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        } else if (!txtEmail.getText().toString().contains("@")) {
            invalidEmail.setVisibility(View.VISIBLE);
            Log.d(TAG, "Email not valid");
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        } else if (txtPassword.getText().toString().isEmpty()) {
            Log.d(TAG, "Pw not valid");
            invalidPassword.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        } else if (!txtRe.getText().toString().equals(txtPassword.getText().toString())) {
            Log.d(TAG, "Does not match");
            invalidMatch.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        } else {
            System.out.println("good");
            Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_SHORT).show();
        }

    }
}