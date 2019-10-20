package com.example.appcaronamobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TelaPrincipalActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private final int rqCadastroCaronaP1 = 300;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        navigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.AddCarona:
                Toast.makeText(this, "Adicionar Carona", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, CadastroCaronaActivity.class);
                startActivityForResult(i, rqCadastroCaronaP1);
                break;
            case R.id.HistoricoCaronas:
                Toast.makeText(this, "Histórico de Caronas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.VerAmigos:
                Toast.makeText(this, "Ver Amigos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.VerVeiculos:
                Toast.makeText(this, "Ver Veículos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AbrirChat:
                Toast.makeText(this, "Abrir Chat", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Sobre:
                Toast.makeText(this, "Sobre", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Configuracoes:
                Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_conta: {
                break;
            }
            case R.id.navigation_mapa: {
                break;
            }
            case R.id.navigation_caronas: {
                break;
            }
        }
        return true;
    }

}