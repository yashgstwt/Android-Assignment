package com.theo.androidAssi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.theo.androidAssi.local.AppDatabase;
import com.theo.androidAssi.local.UserDAO;
import com.theo.androidAssi.model.User;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlinx.coroutines.CoroutineScope;

public class MainActivity extends AppCompatActivity {


    public ArrayList<User> users;
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AppDatabase db = AppDatabase.getAppDataBase(getApplicationContext());
        UserDAO userDao = db.userDAO();
        fetchUsers(() -> {
            if (users != null) {
                Log.d("RX_JAVA", "Users count: " + users);
                disposables.add(Completable.fromAction(() -> {
                            userDao.InsertUsers(users);
                        }).subscribeOn(Schedulers.io())
                                .subscribe(

                                        () ->  Log.d("RX_JAVA", "Users successfully inserted into DB"),
                        throwable -> Log.e("RX_JAVA", "Database Error: " + throwable.getMessage())
                ));

            } else {
                Log.e("RX_JAVA", "Error: Unable to insert  ");
            }
        });


    }

    private void fetchUsers(Runnable onFinished) {

        disposables.add(RetrofitClient.getRetrofit().getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userList -> {
                    Log.d("RX_JAVA", "Users count: " + userList.users.toString());
                    users = userList.users;
                    onFinished.run();
                }, throwable -> {
                    Log.e("RX_JAVA", "Error: " + throwable.getMessage());
                }));
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        disposables.clear();
    }
}