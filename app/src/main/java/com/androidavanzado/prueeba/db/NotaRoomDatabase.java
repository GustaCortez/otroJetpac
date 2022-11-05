package com.androidavanzado.prueeba.db;


import android.arch.persistence.room.Database;
import android.content.Context;

import com.androidavanzado.prueeba.dao.NotaDao;
import com.androidavanzado.prueeba.db.entity.NotaEntity;

//utlizamos el decorador Database
@Database(entities= {NotaEntity.class}, version = 1)
public abstract class  NotaRoomDatabase extends RoomDatabase{
    public  abstract NotaDao notaDao();
    public  static volatile NotaRoomDatabase INSTANCE;

    public static NotaRoomDatabase getDatabase(final Context context){
        if(INSTANCE ==null){
            synchronized (NotaRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                            NotaRoomDatabase.class,"nota_database")
                            build();

                }
            }

        }
        return INSTANCE;
    }
}
