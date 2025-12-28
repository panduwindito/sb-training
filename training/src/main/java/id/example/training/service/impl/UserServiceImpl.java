package id.example.training.service.impl;

import id.example.training.domain.dto.request.CreateUpdateUserDto;
import id.example.training.domain.dto.response.UserInfoDto;
import id.example.training.domain.entity.UserEntity;
import id.example.training.repository.UserRepository;
import id.example.training.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//class for handle business logic for user data


//service annotation for set this class as service
//this class implement UserService interface so this class should implement
//all methods / function from UserService interface
@Service
public class UserServiceImpl implements UserService {

    //repository that will used in this class
    private UserRepository userRepository;


    //constructor
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //logic for get all user data then mapping as userInfoDto
    @Override //annotation for override method from UserService interface
    public List<UserInfoDto> getAllInfo() {
        List<UserEntity> users = userRepository.findAll();
        List<UserInfoDto> userInfo = new ArrayList<>();

        for(UserEntity user: users){
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setId(user.getId());
            userInfoDto.setName(user.getName());
            userInfoDto.setEmail(user.getEmail());
            userInfo.add(userInfoDto);
        }

        return userInfo;
    }

    @Override
    public void createUser(CreateUpdateUserDto createUpdateUserDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID());
        userEntity.setName(createUpdateUserDto.getName());
        userEntity.setEmail(createUpdateUserDto.getEmail());
        userEntity.setPassword(createUpdateUserDto.getPassword());
        userRepository.save(userEntity);
    }

    @Override
    public UserInfoDto getDetail(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(user.getId());
        userInfoDto.setName(user.getName());
        userInfoDto.setEmail(user.getEmail());
        return userInfoDto;
    }

    @Override
    public void updateUser(UUID userId, CreateUpdateUserDto createUpdateUserDto) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        user.setName(createUpdateUserDto.getName());
        user.setEmail(createUpdateUserDto.getEmail());
        user.setPassword(createUpdateUserDto.getPassword());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}
