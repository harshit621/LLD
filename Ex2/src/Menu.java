import java.util.*;

public class Menu {
    Map<String, MenuItem> map;

    public Menu() {
        map = new HashMap<>();
    }

    public void add(MenuItem item) {
        map.put(item.id, item);
    }

    public MenuItem get(String idx) {
        return map.get(idx);
    }

}
