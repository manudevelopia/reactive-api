package info.developia.reactive.api.repository;

import info.developia.persistence.Persistence;
import info.developia.persistence.PersistenceException;
import info.developia.persistence.Repository;
import info.developia.reactive.api.exception.ReactiveApiException;
import info.developia.reactive.api.model.User;
import info.developia.reactive.api.repository.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserRepository extends Repository<UserMapper> {
    private static final Logger LOG = LoggerFactory.getLogger(UserRepository.class);

    public UserRepository(Persistence persistence) {
        super(persistence);
    }

    public List<User> getUsers() {
        try {
            return repository(UserMapper::getAll);
        } catch (PersistenceException e) {
            LOG.error("Error retrieving user list, error {}", e.getMessage());
            throw new ReactiveApiException();
        }
    }

    public User getUser(long id) {
        try {
            return repository((userMapper) -> userMapper.getById(id));
        } catch (PersistenceException e) {
            LOG.error("Error retrieving user by id {}, error {}", id, e.getMessage());
            throw new ReactiveApiException();
        }
    }
}
