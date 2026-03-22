package com.theo.androidAssi.di;

import android.content.Context;

import com.theo.androidAssi.local.AppDatabase;
import com.theo.androidAssi.local.UserDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public static AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return AppDatabase.getAppDataBase(context);
    }

    @Provides
    public static UserDAO provideUserDao(AppDatabase appDatabase) {
        return appDatabase.userDAO();
    }
}
