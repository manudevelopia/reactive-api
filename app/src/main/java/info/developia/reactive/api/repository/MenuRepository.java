package info.developia.reactive.api.repository;

import info.developia.reactive.api.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class MenuRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MenuRepository.class);

    private final Map<String, Menu> menuMap = Map.of(
            "1", new Menu("Menu 1"), "2", new Menu("Menu 2"), "3", new Menu("Menu 3"), "4", new Menu("Menu 4"), "5", new Menu("Menu 5"),
            "6", new Menu("Menu 6"), "7", new Menu("Menu 7"), "8", new Menu("Menu 8"), "9", new Menu("Menu 9"), "10", new Menu("Menu 10")
    );

    public List<Menu> getMenus() {
        var menus = menuMap.values().stream().toList();
        LOG.info("Recovered {} menus", menus.size());
        return menus;
    }

    public Menu getMenu(String id) {
        var menu = menuMap.get(id);
        LOG.info("Recovered menu with id {}", id);
        return menu;
    }
}
