import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);

    private List<MenuItem> menuItems = new ArrayList<>();


    //메뉴 리스트 추가
    private void addMenuList(){
        menuItems.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger",6.5,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

    }


    //생성자
    public Kiosk() {
        addMenuList();
    }


    //메뉴판 화면 출력
    public void printMenu(){
        while (true){
            //메뉴 리스트 출력
            System.out.println("============ MENU =============");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem menuItem = menuItems.get(i);
                System.out.println(i + 1 + "." + menuItem.productName + " | W " + menuItem.productPrice + " | " + menuItem.productInfo);
            }
            System.out.println("0. 키오스크 종료 ");
            //메뉴 번호 입력 (0 입력시 프로그램 종료)
            try {
                int selectMenu = scanner.nextInt();
                if (selectMenu == 0) {
                    return;
                } else {
                    MenuItem menuItem = menuItems.get(selectMenu - 1);
                    System.out.println("선택한 메뉴 : " + menuItem.productName + " " + menuItem.productPrice + " " + menuItem.productInfo + "\n");
                }
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
                scanner.nextLine();
            }
            }

            }

        }





