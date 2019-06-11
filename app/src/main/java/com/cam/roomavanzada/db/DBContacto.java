package com.cam.roomavanzada.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Persona.class},version = 3)
public abstract class DBContacto extends RoomDatabase {
    private static DBContacto INSTANCE;
    public abstract PersonaDao personaDao();

    public static DBContacto getINSTANCE(Context context) {
        if(INSTANCE==null)
        {
            INSTANCE= Room.databaseBuilder(context,
                    DBContacto.class,
                    "DBContactos").allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .build();
        }

        return INSTANCE;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE persona add column sexo varchar(50);");
        }

    };
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE persona add column fechaNac INTEGER;");
        }

    };

}
