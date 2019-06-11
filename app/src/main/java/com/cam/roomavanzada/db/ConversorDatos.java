package com.cam.roomavanzada.db;

import androidx.room.TypeConverter;

import java.util.Date;

public class ConversorDatos {
    @TypeConverter
    public static Date fromTimestamp(Long valor)
    {
        return valor==null?null: new Date(valor);
    }

    @TypeConverter
    public  static Long dateToLong(Date date)
    {
        return date==null?null:date.getTime();
    }
}
