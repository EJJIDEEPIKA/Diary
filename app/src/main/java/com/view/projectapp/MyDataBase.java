package com.view.projectapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {StoredData.class},version =1,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {
    public abstract MyDao myDao();
private  static volatile MyDataBase myDataBase;
static MyDataBase getMyDataBase(final Context context){
    if (myDataBase==null){
        synchronized (MyDataBase.class){
            myDataBase= Room.databaseBuilder(context.getApplicationContext(),MyDataBase.class,"store_database").build();
        }
    }
    return myDataBase;
}

}
