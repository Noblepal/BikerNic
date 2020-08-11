package com.smartyang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.smartyang.R;
import com.smartyang.databinding.ActivityVerificationBinding;
import com.smartyang.util.SharedPrefsManager;

public class VerificationActivity extends AppCompatActivity {

    private ActivityVerificationBinding b;
    private SharedPrefsManager sharedPrefsManager;

    private String validationCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_verification);

        sharedPrefsManager = SharedPrefsManager.getInstance(this);

        if (sharedPrefsManager.hasValidatedCode()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            //TODO: return
        }

        b.btnValidateCode.setOnClickListener(v -> {
            validateCode();
        });
    }

    private void validateCode() {
        validationCode = b.edtValidationCode.getText().toString().trim();

        if (TextUtils.isEmpty(validationCode)) {
            b.edtValidationCode.setError(getString(R.string.please_enter_validation_code));
            return;
        }

        /*
         * TODO: validate code
         * The validation code must be checked with an algorithm with a key
         * in the application in order to verify the validation code.
         * This algorithm will be used also to generate the validation codes.
         * */

        /*On code validated*/
        startActivity(new Intent(this, VehicleSelectActivity.class));
        finish();

    }
}