import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String menuCategory;
    public List<MenuItem> menuItems = new ArrayList<>();


    public String getMenuCategory() {
        return menuCategory;
    }

    //메뉴 목록 출력 (메뉴판)
    public void printMenu(){
        System.out.println("[ " + menuCategory + " MENU" + " ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + 1 + ". "
                    + menuItems.get(i).productName + " | W "
                    + menuItems.get(i).productPrice + " | "
                    + menuItems.get(i).productInfo);
        }
        System.out.println("0. 뒤로 가기 ");
        System.out.println("===================================");
    }


    public Menu(String category) {
        this.menuCategory = category;
    }




}


