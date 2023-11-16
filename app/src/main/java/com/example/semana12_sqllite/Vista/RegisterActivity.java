package com.example.semana12_sqllite.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semana12_sqllite.Controlador.ConexionHelper;
import com.example.semana12_sqllite.Controlador.Utility;
import com.example.semana12_sqllite.R;

public class RegisterActivity extends AppCompatActivity {
    EditText textid;
    EditText txtnombre;
    EditText txtcorreo;
    Button btnregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textid = findViewById(R.id.textid);
        txtnombre = findViewById(R.id.txtnombre);
        txtcorreo = findViewById(R.id.txtcorreo);
        btnregistrar = findViewById(R.id.btnRegistrar);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarUsuario();
            }
        });
    }
    private void RegistrarUsuario() {
        ConexionHelper conn = new ConexionHelper(this, "db_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Utility.CAMPO_ID, textid.getText().toString());
        contentValues.put(Utility.CAMPO_NOMBRE, txtnombre.getText().toString());
        contentValues.put(Utility.CAMPO_CORREO, txtcorreo.getText().toString());

        long idResultado = db.insert(Utility.TABLA_USUARIO,Utility.CAMPO_ID, contentValues);
        Toast.makeText(getApplicationContext(), "ATENCION, ID Registrado: " + idResultado, Toast.LENGTH_SHORT).show();
    }
    private void registrarUsuariosSql(){
        ConexionHelper conn=new ConexionHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String insert="INSERT INTO "+Utility.TABLA_USUARIO
                +"(" +Utility.CAMPO_ID+","+Utility.CAMPO_NOMBRE+"," +Utility.CAMPO_CORREO+")"+
                " VALUES ("+textid.getText().toString()+",'"+txtnombre.getText().toString()+"','"
                +txtcorreo.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"ATENCION, id Resgistrado..."+textid.getText().toString(), Toast.LENGTH_SHORT).show();
        db.close();


    }
}