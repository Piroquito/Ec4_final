package com.edder.ec4_edder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.edder.ec4_edder.databinding.ActivityPrincipalBinding;
import com.edder.ec4_edder.fragmets.HomeFragment;
import com.google.android.material.snackbar.Snackbar;

public class PrincipalActivity extends AppCompatActivity {

    private ActivityPrincipalBinding binding;
    public static String EMAIL = "EMAIL";
    private String email;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE,MODE_PRIVATE);
        setContentView(binding.getRoot());

        setSession();
        addHomeFragment();


    }

    private void addHomeFragment() {
        getSupportFragmentManager().beginTransaction().add(binding.fcvMain.getId(),new HomeFragment()).commit();
    }

    private void setSession() {
        setSupportActionBar(binding.tbPrincipal);
        Intent getIntent = getIntent();
        email = getIntent.getStringExtra(EMAIL);
        binding.txtEmail.setText(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.personajes_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.search){
            Snackbar.make(binding.getRoot(),"Search", Snackbar.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId() == R.id.settings){
            Snackbar.make(binding.getRoot(),"Settings", Snackbar.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId() == R.id.logout){
            sharedPreferences.edit().clear().apply();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;

    }
}