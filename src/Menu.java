import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String menuCategory;
    public List<MenuItem> menuItems = new ArrayList<>();


    public String getMenuCategory() {
        return menuCategory;
    }

    public Menu(String category) {
        this.menuCategory = category;
    }




}


