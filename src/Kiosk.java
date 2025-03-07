import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);

    private List<MenuItem> menuItems = new ArrayList<>();

    private void addMenuList(){
        menuItems.add(new MenuItem("햄부가티온앤온",6.5,"햄버거"));
        menuItems.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("햄버거",6.5,"햄버거"));
        menuItems.add(new MenuItem("햄버거",6.5,"햄버거"));
    }

    public Kiosk() {
        addMenuList();
    }


    //메뉴판 화면 출력
    public void printMenu(){
        while (true){
            System.out.println("============ MENU =============");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem menuItem = menuItems.get(i);
                System.out.println(i + 1 + "." + menuItem.productName + " | " + menuItem.productPrice + " | " + menuItem.productInfo);
            }
            System.out.println("0. 키오스크 종료 ");
            int selectMenu = scanner.nextInt();
            if (selectMenu == 0) {
                return;
            }else{
                    MenuItem menuItem = menuItems.get(selectMenu-1);
                    System.out.println("선택한 메뉴 : "+menuItem.productName+" " +menuItem.productPrice+ " "+ menuItem.productInfo);
                }

            }

        }

    }



