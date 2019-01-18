package com.view.projectapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName="Stored_Data")
public class StoredData {
    @PrimaryKey(autoGenerate = true)
    int head_id;
    @ColumnInfo(name="Head_Name")
    String head_title;
    @ColumnInfo(name="Head_Description")
    String head_desc;

    public int getHead_id() {
        return head_id;
    }

    public void setHead_id(int head_id) {
        this.head_id = head_id;
    }

    public String getHead_title() {
        return head_title;
    }

    public void setHead_title(String head_title) {
        this.head_title = head_title;
    }

    public String getHead_desc() {
        return head_desc;
    }

    public void setHead_desc(String head_desc) {
        this.head_desc = head_desc;
    }
}
