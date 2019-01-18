package com.view.projectapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import static java.security.AccessController.getContext;

public class Listdata<S> extends AppCompatActivity {
GoogleApiClient googleApiClient;
Login login;
public Listdata(){

}
    public Listdata(Login login, GoogleApiClient mGoogleApiClient) {
        this.login=login;
       // googleApiClient=mGoogleApiClient;
       }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, login)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso )
                .build();

    }

    public void add(View view) {
        Intent intent=new Intent(this,Addoption.class);
        startActivity(intent);
    }

    public void search(View view) {
        Intent i1=new Intent(this,Search.class);
        startActivity(i1);
    }

    public void list(View view) {
        Intent i2=new Intent(this,ListDetail.class);
        startActivity(i2);

    }

    public void delete(View view) {
        Intent i3=new Intent(this,Delete.class);
        startActivity(i3);
    }

    public void logout(View view) {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        updateUI(false);
                    }
                });
    }

    private void updateUI(boolean b) {
        if (b) {
            Toast.makeText(login, "Try again", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }

}
