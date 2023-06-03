package info.developia.reactive.api.service;

import info.developia.reactive.api.model.User;
import info.developia.reactive.api.repository.UserRepository;

import java.util.List;

import static info.developia.reactive.api.Launcher.PERSISTENCE;

public class UserService {
    private final UserRepository userRepository = new UserRepository(PERSISTENCE);

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUser(long id) {
        return userRepository.getUser(id);
    }
}
