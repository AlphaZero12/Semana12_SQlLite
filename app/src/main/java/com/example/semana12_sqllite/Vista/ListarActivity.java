package com.example.semana12_sqllite.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.semana12_sqllite.Controlador.ConexionHelper;
import com.example.semana12_sqllite.Modelo.Usuario;
import com.example.semana12_sqllite.R;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {
    ListView listViewUsuarios;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;
    ConexionHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        listViewUsuarios=(ListView) findViewById(R.id.ListViewUsuarios);

        conn=new ConexionHelper(getApplicationContext(),"db_usuarios", null,1);
        consultarListarUsuarios();
    }
    private void consultarListarUsuarios(){
        SQLiteDatabase db= conn.getReadableDatabase();
        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();

        Cursor cursor=db.rawQuery("");
    }
}