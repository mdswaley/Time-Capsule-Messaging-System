package com.example.timecapsulemessagingsystem.Service;

import com.example.timecapsulemessagingsystem.Entity.UserEntity;
import com.example.timecapsulemessagingsystem.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public String addUser(UserEntity userEntity){
        Optional<UserEntity> isExist = userRepo.findByEmail(userEntity.getEmail());

        if(isExist.isPresent()){
            return "User with email "+userEntity.getEmail()+" already exist.";
        }

        userRepo.save(userEntity);

        return "User save successfully with name "+userEntity.getName()+".";
    }
}
