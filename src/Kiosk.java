import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    private final Menu menu;
    private final Scanner scanner = new Scanner(System.in);

    //생성자
     Kiosk(Menu menu) {
        this.menu = menu;
    }

    //메뉴판 화면 출력
    public void start() {
        while (true) {
            //메인메뉴
            System.out.println("============ Main Menu ============");
            System.out.print("1. Burgers\n2. Drinks\n3. Desserts \n");
            System.out.println("0. 종료 ");
            try {
                int selectCategory = scanner.nextInt();
                //메뉴 카테고리 번호 입력 (0 입력시 프로그램 종료)
                switch (selectCategory){
                    case 1 -> {
                        printMenu();
                        printSelectedMenu();
                    }
                    case 2 -> System.out.println("등록된 메뉴가 없습니다.");
                    case 3 -> System.out.println("등록된 메뉴가 없습니다..");
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("잘못된 입력입니다.");
                }
            }catch (InputMismatchException inputMismatchException){
                    System.out.println("잘못된 입력입니다.");
                    scanner.nextLine();
            }

        }

     }


    //메뉴 목록 출력
    private void printMenu() {
        System.out.println("[ " + menu.getMenuCategory() + " MENU" + " ]");
        for (int i = 0; i < menu.menuItems.size(); i++) {
            System.out.println(i + 1 + ". "
                    + menu.menuItems.get(i).productName + " | W "
                    + menu.menuItems.get(i).productPrice + " | "
                    + menu.menuItems.get(i).productInfo);
        }
        System.out.println("0. 뒤로 가기 ");
        System.out.println("===================================");
    }


    //입력받은 번호의 메뉴 출력
    private void printSelectedMenu(){
        try {
            int selectMenu = scanner.nextInt();
            // 입력받은 번호의 메뉴 출력 (0 입력시 메인으로 돌아감)
            if (selectMenu != 0) {
                System.out.println("선택한 메뉴 : " + menu.menuItems.get(selectMenu-1).productName + "  | W "
                        + menu.menuItems.get(selectMenu-1).productPrice + " | "
                        + menu.menuItems.get(selectMenu-1).productInfo + "\n");
            }
            // 메뉴 숫자 초과, 정수 외 다른 타입 입력시 예외처리
        }catch(IndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
        } catch(InputMismatchException inputMismatchException){
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
            scanner.nextLine();
        }
    }

    }








