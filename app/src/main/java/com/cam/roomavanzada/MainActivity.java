package com.cam.roomavanzada;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.widget.Toast;

import com.cam.roomavanzada.db.DBContacto;
import com.cam.roomavanzada.db.Persona;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Persona persona = new Persona();
        persona.setCedula("601-00221252-0022s");
        persona.setNombre("oton");
        persona.setSexo("masculino");
        persona.setFechaNac(Calendar.getInstance().getTime());
        try
        {
            DBContacto.getINSTANCE(this).personaDao().insertar(persona);
            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
        }
        catch (SQLiteConstraintException e)
        {
            Toast.makeText(this, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
