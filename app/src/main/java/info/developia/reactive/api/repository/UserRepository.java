package info.developia.reactive.api.repository;

import info.developia.reactive.api.PersistenceException;
import info.developia.reactive.api.Persitence;
import info.developia.reactive.api.Repository;
import info.developia.reactive.api.exception.ReactiveApiException;
import info.developia.reactive.api.repository.mapper.UserMapper;
import info.developia.reactive.api.model.User;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserRepository extends Repository<UserMapper> {
    private static final Logger LOG = LoggerFactory.getLogger(UserRepository.class);

    public UserRepository(Persitence persitence) {
        super(persitence);
    }

    public Single<List<User>> getUsers() {
        try {
            return repository(UserMapper::getAll);
        } catch (PersistenceException e) {
            LOG.error("Error retrieving user list, error {}", e.getMessage());
            throw new ReactiveApiException();
        }
    }


    public Observable<User> getUsersStream() {
        LOG.info("Recovered menus Stream");
        return Observable.create(subscriber -> {
            try (SqlSession session = getSession().openSession()) {
                session.getMapper(UserMapper.class).getAll().forEach(subscriber::onNext);
            } catch (Exception e) {
                subscriber.onError(e);
            } finally {
                subscriber.onComplete();
            }
        });
    }

    public Single<User> getUser(long id) {
        try {
            return repository((userMapper) -> userMapper.getById(id));
        } catch (PersistenceException e) {
            LOG.error("Error retrieving user by id {}, error {}", id, e.getMessage());
            throw new ReactiveApiException();
        }
    }
}
