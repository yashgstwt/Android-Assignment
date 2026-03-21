package com.theo.androidAssi.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.theo.androidAssi.model.Converters;
import com.theo.androidAssi.model.User;


@Database(entities = {User.class} , version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();

    public static volatile AppDatabase appDataBase;

    public static AppDatabase getAppDataBase(final Context context){

        if(appDataBase == null){
            synchronized (AppDatabase.class) {
                if (appDataBase == null) {
                    appDataBase = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "my_database").build();
                }
            }
        }

        return appDataBase;
    }


}
