package info.developia.reactive.api.repository;

import info.developia.reactive.api.Persitence;
import info.developia.reactive.api.mapper.UserMapper;
import info.developia.reactive.api.model.User;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(UserRepository.class);
    private final Persitence persitence = new Persitence();

    public Single<List<User>> getUsers() {
        try (SqlSession session = persitence.getSession().openSession()) {
            var users = session.getMapper(UserMapper.class).getAll();
            return Single.just(users);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    public Observable<User> getUsersStream() {
        LOG.info("Recovered menus Stream");
        return Observable.create(subscriber -> {
            try (SqlSession session = persitence.getSession().openSession()) {
                session.getMapper(UserMapper.class).getAll().forEach(subscriber::onNext);
            } catch (Exception e) {
                subscriber.onError(e);
            } finally {
                subscriber.onComplete();
            }
        });
    }

//    public Single<User> getUser(String id) {
//        var menu = menuMap.get(id);
//        LOG.info("Recovered menu with id {}", id);
//        return Single.just(menu);
//    }
}
