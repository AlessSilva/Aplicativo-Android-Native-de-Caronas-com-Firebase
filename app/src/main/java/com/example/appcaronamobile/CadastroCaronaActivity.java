package com.example.appcaronamobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.appcaronamobile.Fragments.CadastroCarona1;
import com.example.appcaronamobile.Fragments.CadastroCarona2;
import com.example.appcaronamobile.Model.Carona;
import com.example.appcaronamobile.Model.Usuario;
import com.example.appcaronamobile.Model.Veiculo;
import com.example.appcaronamobile.Repository.MyListener2;
import com.example.appcaronamobile.Util.Codes.ResultCodes;
import com.google.android.gms.maps.model.LatLng;

public class CadastroCaronaActivity extends AppCompatActivity implements MyListener2 {

    FragmentManager fragmentManager = null;

    private Usuario usuario;
    private Veiculo veiculo;
    private Carona carona;
    private int vagas;
    private String horario;
    private String data;
    private String destino;
    private boolean ajuda;
    private LatLng latLng = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_carona);

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        carona = (Carona) getIntent().getSerializableExtra("carona");

        fragmentManager = getSupportFragmentManager();

        CadastroCarona1 cadastroCarona1 = new CadastroCarona1();
        Bundle arguments = new Bundle();
        arguments.putSerializable("usuario",usuario);
        if( carona!= null ){
            arguments.putSerializable("carona",carona);
        }
        cadastroCarona1.setArguments(arguments);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frame, cadastroCarona1, "CadastroCaronaPart1");
        transaction.commitAllowingStateLoss();

    }

    public void proximoFragmentoP1(int vagas, Veiculo veiculo, String horario, String data, String destino, boolean ajuda ) {
        this.vagas = vagas;
        this.horario = horario;
        this.destino = destino;
        this.ajuda = ajuda;
        this.data = data;
        this.veiculo = veiculo;

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame, new CadastroCarona2(), "CadastroCaronaPart2");
        transaction.commitAllowingStateLoss();

    }

    public void voltarFragmentoP1(){

        setResult(ResultCodes.CAD_CARPOOL_CANCEL);
        finish();

    }

    public void finalizarFragmentoP2(){

        Intent intent = new Intent();
        intent.putExtra("vagas",vagas);
        intent.putExtra("horario",horario);
        intent.putExtra("data",data);
        intent.putExtra("destino",destino);
        intent.putExtra("ajuda",ajuda+"");
        intent.putExtra("lat",latLng.latitude+"");
        intent.putExtra("long",latLng.longitude+"");
        intent.putExtra("veiculo",veiculo);

        if( carona != null ){
            intent.putExtra("id",carona.getId());
            setResult(ResultCodes.EDIT_CARPÒOL_SUCESS,intent);
        }else {
            setResult(ResultCodes.CAD_CARPOOL_SUCESS, intent);
        }
        finish();
    }

    public void voltarFragmentoP2(){

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frame, new CadastroCarona1(), "CadastroCaronaPart1");
        transaction.commitAllowingStateLoss();

    }

    public void receberLatLng(LatLng latLn) {
        latLng = latLn;
    }
}