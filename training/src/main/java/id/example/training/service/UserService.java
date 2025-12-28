package id.example.training.service;

import id.example.training.domain.dto.request.CreateUpdateUserDto;
import id.example.training.domain.dto.response.UserInfoDto;

import java.util.List;
import java.util.UUID;

//interface class for user data

public interface UserService {
    List<UserInfoDto> getAllInfo();
    void createUser(CreateUpdateUserDto createUpdateUserDto);
    UserInfoDto getDetail(UUID userId);
    void updateUser(UUID userId, CreateUpdateUserDto updateUserDto);
    void deleteUser(UUID userId);
}
