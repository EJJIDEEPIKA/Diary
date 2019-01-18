package com.view.projectapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private String TAG=this.getClass().getSimpleName();
    MutableLiveData<List<StoredData>> mutableLiveData;
    private MyDataBase m;
    private MyDao myDao;

    public MyViewModel(@NonNull Application application) {
        super(application);
        m=MyDataBase.getMyDataBase(application);
        myDao=m.myDao();
        mutableLiveData = new MutableLiveData<List<StoredData>>();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG,"ViewModel Destroyed");
    }
    public void insert(StoredData s){
        new InsertAysnTask(myDao).execute(s);
    }
    public MutableLiveData<java.util.List<StoredData>> getList() {
        if(mutableLiveData==null){
            mutableLiveData=new MutableLiveData<java.util.List<StoredData>>();
        }
        return mutableLiveData;
    }

    public void setList(List<StoredData> list) {
        mutableLiveData.setValue(list);
    }

    private class InsertAysnTask extends AsyncTask<StoredData,Void,Void> {
        MyDao mmyDao;
        public InsertAysnTask(MyDao myDao) {
            mmyDao=myDao;
        }

        @Override
        protected Void doInBackground(StoredData... storedData) {
            mmyDao.insertData(storedData[0]);
            return null;
        }
    }


    }


