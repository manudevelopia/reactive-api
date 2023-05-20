package info.developia.reactive.api.service;

import info.developia.reactive.api.model.Menu;
import info.developia.reactive.api.repository.MenuRepository;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;

public class MenuService {
    private final MenuRepository menuRepository = new MenuRepository();

    public Single<List<Menu>> getMenus() {
        return menuRepository.getMenus();
    }

    public Observable<Menu> getMenusStream() {
        return menuRepository.getMenusStream();
    }

    public Single<Menu> getMenu(String id) {
        return menuRepository.getMenu(id);
    }
}
