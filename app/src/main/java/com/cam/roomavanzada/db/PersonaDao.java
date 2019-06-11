package com.cam.roomavanzada.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonaDao {
@Insert(onConflict = OnConflictStrategy.FAIL)
    void insertar(Persona persona);

@Delete
    void borrar(Persona persona);

@Update(onConflict = OnConflictStrategy.REPLACE)
    void actualizar(Persona persona);

@Query("select * from persona")
    List<Persona> obtenerTodo();
}
