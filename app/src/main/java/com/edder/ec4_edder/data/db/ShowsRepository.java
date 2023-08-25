package com.edder.ec4_edder.data.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.edder.ec4_edder.model.ShowEntity;

import java.util.List;

public class ShowsRepository {

    private ShowDao dao;
    private Ec4Database db;

    public ShowsRepository(Application application) {
        db = Ec4Database.getInstance(application);
        dao = db.showDao();
    }

    public void addShow(ShowEntity showEntity){
        Ec4Database.dataBaseWriteExecuter.execute(()->
                dao.addShow(showEntity));
        dao.addShow(showEntity);

    }

    public LiveData<List<ShowEntity>> getAll(){
        return dao.getAll();

    }
}
