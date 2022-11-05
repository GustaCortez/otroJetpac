package com.androidavanzado.prueeba.dao;
import android.arch.persistence.room.Dao;

import com.androidavanzado.prueeba.db.entity.NotaEntity;

@Dao
public interface NotaDao {
    @Insert
    void insert(NotaEntity nota);
    @Update update(NotaEntity nota);

    @Query("DELETE FROM notas")
    void deleteAll();
    @Query("DELETE FROM notas WHERE id= : idNota")
    void deleteById(int idNota);

    @Query("SELECTED FROM notas ORDER BY titulo ASC")
    LiveDataList<NotaEntity> getAll();
    @Query ("SELECTED FROM notas WHERE favorita LIKE 1")
    LiveDataList<NotaEntity> getAllFavoritas();

}
