package info.developia.reactive.api.service;

import info.developia.reactive.api.model.Menu;
import info.developia.reactive.api.repository.MenuRepository;

import java.util.List;

public class MenuService {
    private final MenuRepository menuRepository = new MenuRepository();

    public List<Menu> getMenus() {
        return menuRepository.getMenus();
    }

    public Menu getMenu(String id) {
        return menuRepository.getMenu(id);
    }
}
