package com.theo.androidAssi.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.theo.androidAssi.R;
import com.theo.androidAssi.model.User;
import com.theo.androidAssi.viewmodel.UserViewModel;

public class HomeScreen extends Fragment implements UserAdapter.OnUserClickListener {

    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private UserViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new UserAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        viewModel.getUsers().observe(getViewLifecycleOwner(), users -> {
            if (users != null) {
                adapter.setUsers(users);
            }
        });

        viewModel.fetchUsers();
    }

    @Override
    public void onUserClick(User user) {
        Bundle bundle = new Bundle();
        bundle.putInt("userId", user.id);
        Navigation.findNavController(requireView()).navigate(R.id.action_homeScreen_to_detailScreen, bundle);
    }
}