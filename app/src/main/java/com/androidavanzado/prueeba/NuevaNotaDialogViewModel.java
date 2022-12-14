package com.androidavanzado.prueeba;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.androidavanzado.prueeba.db.entity.NotaEntity;

import java.util.List;

public class NuevaNotaDialogViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private LiveDataList<NotaEntity> allNotas
            private NotaRepository notaRepository;

    public NuevaNotaDialogViewModel(Application application){
        super(application);
        notaRepository = new NotaRepository(application);
        allNotas =notaRepository.getAll();
    }

    LiveData<List<NotaEntity>>getAllNotas(){
        return allNotas;}

        public void nuevaNotaEntity(NotaEntity notaEntity){
        notaRepository.insert(nuevaNotaEntity();
        }
    }
}