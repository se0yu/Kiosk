import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    public Menu menu;
    private final Scanner scanner = new Scanner(System.in);
    private final Cart cart = new Cart();
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
            if(cart.checkCartNotEmpty()){
                System.out.println("[ ORDER MENU ]");
                System.out.println("4.  Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5.  Cancel       | 진행중인 주문을 취소합니다.");
            }
            try {
                int selectCategory = scanner.nextInt();
                //메뉴 카테고리 번호 입력 (0 입력시 프로그램 종료)
                //장바구니 비어있을 경우 Order Menu 하단 안보이게
                switch (selectCategory){
                    case 1 -> {
                        menu.printMenu();
                        printSelectedMenu();
                    }
                    case 2 -> System.out.println("등록된 메뉴가 없습니다.");
                    case 3 -> System.out.println("등록된 메뉴가 없습니다..");
                    case 4 -> {
                        if(cart.checkCartNotEmpty()){
                            cart.printCartList();
                            System.out.println("1. 주문      2. 메뉴판");
                            cart.orderCart(scanner.nextInt());
                        }else {
                            wrongInput();
                        }
                    }
                    case 5 ->{
                        if(cart.checkCartNotEmpty()){
                            cart.cancelOrder();
                        }else{
                            wrongInput();
                        }
                    }
                    case 0 -> {
                        return;
                    }
                    default -> wrongInput();
                }
            }catch (InputMismatchException inputMismatchException){
                    wrongInput();
                    scanner.nextLine();
            }
        }
     }


    //입력받은 번호의 메뉴 출력
    private void printSelectedMenu(){
        try {
            int selectMenu = scanner.nextInt();
            // 입력받은 번호의 메뉴 출력 (0 입력시 메인으로 돌아감)
            if (selectMenu != 0) {
                MenuItem selectedMenuItem = menu.menuItems.get(selectMenu-1);
                System.out.println("선택한 메뉴 : " + selectedMenuItem.productName + "  | W "
                        + selectedMenuItem.productPrice + " | "
                        + selectedMenuItem.productInfo + "\n" );
                addCart(selectedMenuItem);
            }
            // 메뉴 숫자 초과, 정수 외 다른 타입 입력시 예외처리
        }catch(IndexOutOfBoundsException indexOutOfBoundsException){
            wrongInput();
        }
    }

    //장바구니에 물건 추가
    private void addCart(MenuItem menuItem){
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? \n 1. 확인          2. 취소");
        int inputMenu = scanner.nextInt();
             switch (inputMenu){
                 case 1 -> {
                     cart.cartList.add(menuItem);
                     System.out.println(menuItem.productName+" 가 장바구니에 추가되었습니다.");
                 }
                 case 2 -> System.out.println("메뉴로 돌아갑니다.");
                 default -> wrongInput();
             }
         }

         //에러 발생시 출력
     private void wrongInput(){
         System.out.println("잘못된 입력입니다. 메뉴로 돌아갑니다.");
     }
}










