package com.theo.androidAssi.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.theo.androidAssi.R;
import com.theo.androidAssi.model.User;
import com.theo.androidAssi.viewmodel.UserViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailScreen extends Fragment {

    private int userId;
    private UserViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userId = getArguments().getInt("userId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton backButton = view.findViewById(R.id.back_button);
        if (backButton != null) {
            backButton.setOnClickListener(v -> Navigation.findNavController(v).navigateUp());
        }

        ImageView profileImage = view.findViewById(R.id.profile_image);
        TextView roleText = view.findViewById(R.id.role);
        TextView nameText = view.findViewById(R.id.name);
        TextView medianNameText = view.findViewById(R.id.median_name);
        TextView addressText = view.findViewById(R.id.address);
        TextView emailText = view.findViewById(R.id.email_address);
        
        TextView birthDateText = view.findViewById(R.id.txtBirthDate);
        TextView bloodGroupText = view.findViewById(R.id.txtBlood);
        TextView hairEyeText = view.findViewById(R.id.txtHairEyeColor);
        TextView ageGenderText = view.findViewById(R.id.txtAgeGender);
        TextView heightWeightText = view.findViewById(R.id.txtHeightWeight);
        TextView usernameText = view.findViewById(R.id.txtUsername);
        
        TextView companyText = view.findViewById(R.id.txtCompany);
        TextView companyAddressText = view.findViewById(R.id.txtCompanyAddress);
        TextView educationText = view.findViewById(R.id.txtEducation);
        
        TextView fullAddressText = view.findViewById(R.id.lblFullAddress);
        TextView coordinatesText = view.findViewById(R.id.lblAddressCoordinates);

        viewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        viewModel.getUsers().observe(getViewLifecycleOwner(), users -> {
            if (users != null) {
                for (User user : users) {
                    if (user.id == userId) {
                        bindUserData(user, profileImage, roleText, nameText, medianNameText, addressText, emailText,
                                birthDateText, bloodGroupText, hairEyeText, ageGenderText, heightWeightText, usernameText,
                                companyText, companyAddressText, educationText, fullAddressText, coordinatesText);
                        break;
                    }
                }
            }
        });
    }

    private void bindUserData(User user, ImageView profileImage, TextView role, TextView name, TextView medianName,
                              TextView address, TextView email, TextView birthDate, TextView blood, TextView hairEye,
                              TextView ageGender, TextView heightWeight, TextView username, TextView company,
                              TextView companyAddress, TextView education, TextView fullAddress, TextView coordinates) {
        
        Glide.with(this)
                .load(user.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(profileImage);

        role.setText(user.role);
        name.setText(user.firstName + " " + user.lastName);
        medianName.setText(user.maidenName);
        if (user.address != null) {
            address.setText(user.address.address + ", " + user.address.city);
            fullAddress.setText(user.address.address + ", " + user.address.city + ", " + user.address.state);
            if (user.address.coordinates != null) {
                coordinates.setText("Lat: " + user.address.coordinates.lat + ", Lng: " + user.address.coordinates.lng);
            }
        }
        email.setText(user.email);
        
        birthDate.setText(user.birthDate);
        blood.setText(user.bloodGroup);
        if (user.hair != null) {
            hairEye.setText(user.hair.color + " hair, " + user.eyeColor + " eyes");
        }
        ageGender.setText(user.age + ", " + user.gender);
        heightWeight.setText(user.height + "cm, " + user.weight + "kg");
        username.setText(user.username);
        
        if (user.company != null) {
            company.setText(user.company.name + " (" + user.company.department + ")");
            if (user.company.address != null) {
                companyAddress.setText(user.company.address.address + ", " + user.company.address.city);
            }
        }
        education.setText(user.university);
    }
}
