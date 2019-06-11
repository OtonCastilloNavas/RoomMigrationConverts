package com.cam.roomavanzada.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity
@TypeConverters({ConversorDatos.class})
public class Persona {
    @PrimaryKey
    @NonNull
    private String cedula;
    private String Nombre;

    private Date fechaNac;

    private String sexo;

    public Persona() {
    }

    @Ignore
    public Persona(String cedula, String nombre, Date fechaNac) {
        this.cedula = cedula;
        Nombre = nombre;
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
}