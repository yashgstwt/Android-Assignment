package com.theo.androidAssi.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.theo.androidAssi.model.User;
import java.util.List;
@Dao
public interface UserDAO {
    @Insert
    void InsertUsers(List<User> users);

    @Query("SELECT * FROM users")
    LiveData<List<User>> getUsers();

    @Delete
    void deleteUser(User user);

}
