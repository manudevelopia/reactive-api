package info.developia.reactive.api.service;

import info.developia.reactive.api.model.User;
import info.developia.reactive.api.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public Single<List<User>> getUsers() {
        return userRepository.getUsers();
    }

    public Observable<User> getUsersStream() {
        return userRepository.getUsersStream();
    }

    public Single<User> getUser(String id) {
        return null;
    }
}
