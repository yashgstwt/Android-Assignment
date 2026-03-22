package com.theo.androidAssi.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

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

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeScreen extends Fragment implements UserAdapter.OnUserClickListener {

    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private UserViewModel viewModel;
    private ProgressBar progressBar;
    private LinearLayout errorLayout;
    private TextView errorText;
    private Button retryButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);
        errorLayout = view.findViewById(R.id.errorLayout);
        errorText = view.findViewById(R.id.errorText);
        retryButton = view.findViewById(R.id.retryButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new UserAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        viewModel.getUsers().observe(getViewLifecycleOwner(), users -> {
            if (users != null && !users.isEmpty()) {
                adapter.setUsers(users);
                errorLayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            } else if (users != null && users.isEmpty()) {
                viewModel.refreshUsers();
            }
        });

        viewModel.getIsLoading().observe(getViewLifecycleOwner(), isLoading -> {
            progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            if (isLoading) {
                errorLayout.setVisibility(View.GONE);
            }
        });

        viewModel.getErrorMessage().observe(getViewLifecycleOwner(), error -> {
            if (error != null && (viewModel.getUsers().getValue() == null || viewModel.getUsers().getValue().isEmpty())) {
                errorText.setText("No Internet Connection!!");
                errorLayout.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            }
        });

        retryButton.setOnClickListener(v -> viewModel.refreshUsers());
    }

    @Override
    public void onUserClick(User user) {
        Bundle bundle = new Bundle();
        bundle.putInt("userId", user.id);
        Navigation.findNavController(requireView()).navigate(R.id.action_homeScreen_to_detailScreen, bundle);
    }
}
