package com.fluent.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fluent.R;
import com.fluent.fragment.LoadingDialogFragment;
import com.fluent.utility.PreferencesUtil;

public class AuthActivity extends AppCompatActivity {

    private static final String TAG = AuthActivity.class.getSimpleName();

    private LinearLayout authContainer;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmEditText;
    private EditText nameEditText;
    private Button loginButton;
    private Button registerButton;
    private TextView switchTextView;
    private ImageView authImageView;
    private Context context;
    private TextView authTextView;
    private LoadingDialogFragment loadingDialog;


    private boolean isLoginView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (PreferencesUtil.getHasLogin(this)){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        } else {
            setContentView(R.layout.activity_auth);
            bindView();
            switchToLogin();
            context = this;
        }
    }

    private void bindView() {
        authContainer = findViewById(R.id.auth_container);
        emailEditText = findViewById(R.id.auth_email);
        passwordEditText = findViewById(R.id.auth_password);
        confirmEditText = findViewById(R.id.auth_confirm);
        nameEditText = findViewById(R.id.auth_name);
        loginButton = findViewById(R.id.auth_login);
        registerButton = findViewById(R.id.auth_register);
        switchTextView = findViewById(R.id.auth_switch);
        authImageView = findViewById(R.id.auth_logo);
        authTextView = findViewById(R.id.auth_word);
        loadingDialog = new LoadingDialogFragment(this);
        loadingDialog.setCancelable(false);
        loadingDialog.setCanceledOnTouchOutside(false);
        Glide.with(this).load(getImage("fluent_logo")).fitCenter().into(authImageView);
    }

    public void login(final View view) {
        final String email = emailEditText.getText().toString().trim();
        final String password = passwordEditText.getText().toString().trim();

        loadingDialog.show();
        if (email.equals("admin") && password.equals("admin")){
            loadingDialog.dismiss();
            finish();
            startActivity(new Intent(AuthActivity.this, MainActivity.class));
        } else {
            loadingDialog.dismiss();
            showSnackBar((AuthActivity)view.getContext(), "Email or password is incorrect!");
        }
    }


    public void register(View view) {
        final String name = nameEditText.getText().toString().trim();
        final String email = emailEditText.getText().toString().trim();
        final String password = passwordEditText.getText().toString().trim();
        final String confirm = confirmEditText.getText().toString().trim();

        loadingDialog.show();
        if (password.equals(confirm)) {
            loadingDialog.dismiss();
            finish();
            startActivity(new Intent(AuthActivity.this, MainActivity.class));
        } else {
            loadingDialog.dismiss();
            showSnackBar(this, "Password didn't match!");
        }
    }

    public void switchAction(View view) {
        isLoginView = !isLoginView;
        if (isLoginView) {
            switchToLogin();
        } else {
            switchToRegister();
        }
    }

    private void switchToLogin() {
        TransitionManager.beginDelayedTransition(authContainer);
        nameEditText.setVisibility(View.GONE);
        confirmEditText.setVisibility(View.GONE);
        loginButton.setVisibility(View.VISIBLE);
        registerButton.setVisibility(View.GONE);
        authTextView.setText(R.string.register_word);
        switchTextView.setText(getString(R.string.register));
    }

    private void switchToRegister() {
        TransitionManager.beginDelayedTransition(authContainer);
        nameEditText.setVisibility(View.VISIBLE);
        confirmEditText.setVisibility(View.VISIBLE);
        loginButton.setVisibility(View.GONE);
        registerButton.setVisibility(View.VISIBLE);
        switchTextView.setText(getString(R.string.login));
        authTextView.setText(getString(R.string.login_word));

    }

    public int getImage(String imageName) {

        int drawableResourceId = this.getResources().getIdentifier(imageName, "drawable", this.getPackageName());

        return drawableResourceId;
    }

    public void showSnackBar(Activity activity, String message){
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}