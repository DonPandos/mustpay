package com.mustpay.encryptrestapi.config;

import com.mustpay.encryptrestapi.model.UserModel;
import com.mustpay.encryptrestapi.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData implements ApplicationRunner {
    private final UserRepository userRepository;

    public InitData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<UserModel> userModelList = List.of(
                new UserModel(1L, "Ivan", "Ivanov", "Ivanovich"),
                new UserModel(2L, "Petr", "Petrov", "Petrovich"),
                new UserModel(3L, "Kirill", "Kirillov", "Kirillovich"),
                new UserModel(4L, "Bohdan", "Bohdanov", "Bohdanovich"),
                new UserModel(5L, "Alexander", "Alexandrov", "Alexandrovich")
        );

        userRepository.saveAll(userModelList);
    }
}
