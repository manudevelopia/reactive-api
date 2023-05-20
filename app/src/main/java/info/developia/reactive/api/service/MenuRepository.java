package info.developia.reactive.api.service;

import info.developia.reactive.api.model.Menu;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MenuRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MenuRepository.class);

    private final Map<String, Menu> menuMap = Map.of(
            "1", new Menu("Menu 1"), "2", new Menu("Menu 2"), "3", new Menu("Menu 3"), "4", new Menu("Menu 4"), "5", new Menu("Menu 5"),
            "6", new Menu("Menu 6"), "7", new Menu("Menu 7"), "8", new Menu("Menu 8"), "9", new Menu("Menu 9"), "10", new Menu("Menu 10")
    );

    public Single<List<Menu>> getMenus() {
        var menus = menuMap.values().stream().toList();
        LOG.info("Recovered {} menus", menus.size());
        return Single.just(menus);
    }


    public Observable<Menu> getMenusStream() {
        LOG.info("Recovered menus Stream");
        return Observable.create(subscriber -> {
            try {
                menuMap.values().forEach(subscriber::onNext);
            } catch (Exception e) {
                subscriber.onError(e);
            } finally {
                subscriber.onComplete();
            }
        });
    }

    public Single<Menu> getMenu(String id) {
        var menu = menuMap.get(id);
        LOG.info("Recovered menu with id {}", id);
        return Single.just(menu);
    }
}
