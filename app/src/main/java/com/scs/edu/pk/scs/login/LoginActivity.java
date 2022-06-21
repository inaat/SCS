package com.scs.edu.pk.scs.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.scs.edu.pk.scs.Constant;
import com.scs.edu.pk.scs.MainActivity;
import com.scs.edu.pk.scs.R;
import com.scs.edu.pk.scs.model.Login;
import com.scs.edu.pk.scs.networking.ApiClient;
import com.scs.edu.pk.scs.networking.ApiInterface;
import com.scs.edu.pk.scs.utils.BaseActivity;
import com.scs.edu.pk.scs.utils.Utils;

import java.util.Objects;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    private Activity context;

    EditText etxtEmail, etxtPassword;
    TextView txtLogin;
    SharedPreferences sp;
    ProgressDialog loading;
    Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Objects.requireNonNull(getSupportActionBar()).hide();

        etxtEmail = findViewById(R.id.etxt_email);
        etxtPassword = findViewById(R.id.etxt_password);
        txtLogin = findViewById(R.id.txt_login);
        utils = new Utils();







        txtLogin.setOnClickListener(v -> {
            String email1 = etxtEmail.getText().toString().trim();
            String password1 = etxtPassword.getText().toString().trim();

            if (email1.isEmpty() || !email1.contains("@") || !email1.contains(".")) {
                etxtEmail.setError(getString(R.string.enter_valid_email));
                etxtEmail.requestFocus();
            } else if (password1.isEmpty()) {
                etxtPassword.setError(getString(R.string.please_enter_password));
                etxtPassword.requestFocus();
            } else {


                if (utils.isNetworkAvailable(LoginActivity.this)) {
                    login(email1, password1);
                } else {
                    Toasty.error(LoginActivity.this, R.string.no_network_connection, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    //login method
    private void login(String email, String password) {

        loading = new ProgressDialog(this);
        loading.setCancelable(false);
        loading.setMessage(getString(R.string.please_wait));
        loading.show();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Login> call = apiInterface.login(email, password);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(@NonNull Call<Login> call, @NonNull Response<Login> response) {

                if (response.body() != null && response.isSuccessful()) {
                    String value = response.body().getToken();
                    Utils.setSharedPreferenceBoolean(getApplicationContext(), "IsLoggingIn", true);
                    Utils.setSharedPreference(getApplicationContext(), Constant.Token,value);
                    Intent asd = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(asd);
                    finish();
                } else {
                    loading.dismiss();

                }
            }

            @Override
            public void onFailure(@NonNull Call<Login> call, @NonNull Throwable t) {

                loading.dismiss();

            }
        });
    }
}
