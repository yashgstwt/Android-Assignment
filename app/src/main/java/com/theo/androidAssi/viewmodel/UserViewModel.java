package com.theo.androidAssi.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.theo.androidAssi.model.User;
import com.theo.androidAssi.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@HiltViewModel
public class UserViewModel extends ViewModel {

    private final UserRepository userRepository;
    private final LiveData<List<User>> users;
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    public UserViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.users = userRepository.getUsersFromDb();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void fetchUsersIfNeeded() {
        List<User> currentUsers = users.getValue();
        if (currentUsers == null || currentUsers.isEmpty()) {
            refreshUsers();
        }
    }

    public void refreshUsers() {
        isLoading.setValue(true);
        disposables.add(userRepository.refreshUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    isLoading.setValue(false);
                }, throwable -> {
                    errorMessage.setValue(throwable.getMessage());
                    isLoading.setValue(false);
                    Log.e("UserViewModel", "Error: " + throwable.getMessage());
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
