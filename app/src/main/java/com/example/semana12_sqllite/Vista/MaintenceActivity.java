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

public class MaintenceActivity extends AppCompatActivity {
    EditText textid;
    EditText txtnombre;
    EditText txtcorreo;
    Button btnconsultar, btnupdate,btndelete;
    ConexionHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintence);
        conn = new ConexionHelper(getApplicationContext(), "bd_usuarios", null, 1);
        textid = (EditText) findViewById(R.id.textid);
        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtcorreo = (EditText) findViewById(R.id.txtcorreo);

        btnconsultar = (Button) findViewById(R.id.btnBuscar);
        btnupdate = (Button) findViewById(R.id.btnActualizar);
        btndelete = (Button) findViewById(R.id.btnEliminar);

        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();

            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarUsuario();
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarUsuario();
            }
        });
        private void actualizarUsuario(){
            SQLiteDatabase db= conn.getReadableDatabase();
            String[] parametros ={textid.getText().toString()};
            ContentValues values = new ContentValues();
            values.put(Utility.CAMPO_NOMBRE, txtnombre.getText().toString());
            values.put(Utility.CAMPO_CORREO, txtcorreo.getText().toString());

            db.update(Utility.TABLA_USUARIO, values, Utility.CAMPO_ID + "=?", parametros);
            Toast.makeText(getApplicationContext(),"ATENCION, se actualizo el usuario",
                    Toast.LENGTH_LONG).show();
            txtnombre.setText("");
            txtcorreo.setText("");
            db.close();

        }

        private void consultar{
            SQLiteDatabase db= conn.getReadableDatabase();
            String[] parametros ={textid.getText().toString()};

            ContentValues values = new ContentValues();


        }
        private void eliminarUsuario(){
            SQLiteDatabase db= conn.getReadableDatabase();
            String[] parametros ={textid.getText().toString()};
            db.delete(Utility.TABLA_USUARIO, Utility.CAMPO_ID + "=?", parametros);
            Toast.makeText(getApplicationContext(),"ATENCION, se elimino el usuario",
                    Toast.LENGTH_LONG).show();
            textid.setText("");
            limpiar();
            db.close();
        }
            private void limpiar(){
            textid.setText("");
            txtnombre.setText("");
            txtcorreo.setText("");
        }
        }


    }
