package com.theo.androidAssi.repository;

import androidx.lifecycle.LiveData;

import com.theo.androidAssi.ApiService;
import com.theo.androidAssi.local.UserDAO;
import com.theo.androidAssi.model.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Singleton
public class UserRepository {

    private final ApiService apiService;
    private final UserDAO userDAO;

    @Inject
    public UserRepository(ApiService apiService, UserDAO userDAO) {
        this.apiService = apiService;
        this.userDAO = userDAO;
    }

    public LiveData<List<User>> getUsersFromDb() {
        return userDAO.getUsers();
    }

    public Completable refreshUsers() {
        return apiService.getUsers()
                .subscribeOn(Schedulers.io())
                .flatMapCompletable(root -> Completable.fromAction(() -> {
                    userDAO.InsertUsers(root.users);
                }));
    }
}
