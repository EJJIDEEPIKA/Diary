package com.view.projectapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Query("select * from Stored_Data")
    List<StoredData> getAllData();
    @Insert
    void insertData(StoredData sd);

    @Update
    void updateDate(StoredData sd);
@Query("delete from Stored_Data  where Head_Name=:head_title")
    void deleteData(String head_title);
}