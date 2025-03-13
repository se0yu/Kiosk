import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    private final Scanner scanner = new Scanner(System.in);
    public List<MenuItem> cartList = new ArrayList<>();
    public double sumPrice;

    //장바구니 리스트 출력
    public void printCartList(){
        System.out.println("[ Orders ]");
        sumPrice = 0;
        for(MenuItem cartList : cartList){
            sumPrice+=cartList.productPrice;
            System.out.println(cartList.productName +" | "
                    + cartList.productPrice+" | "
                    + cartList.productInfo);
        }
        System.out.println("\n[ Total ]");
        System.out.println("W "+sumPrice);
    }

    //장바구니 내역 결제
    public void orderCart(int selectNum){
        switch (selectNum){
            case 1 -> {
                System.out.println("할인 정보를 입력해 주세요.");
                System.out.println("1. 국가유공자 : 10% \n2. 군인 : 5%\n3. 학생 : 3%\n4. 일반 : 0%");
                discount(scanner.nextInt());
                cartList.clear();
            }
            case 2 -> System.out.println("메뉴로 돌아갑니다.");
            default -> System.out.println("잘못된 입력입니다.");
        }
    }

    //주문 취소(장바구니 초기화)
    public void cancelOrder(){
        System.out.println("주문이 취소 되었습니다. 메뉴로 돌아갑니다.");
        cartList.clear();
    }

    private void discount(int selectedUserType){
        double totalPrice;
        UserType userType = UserType.userType(selectedUserType);
        totalPrice = userType.discount(sumPrice);
        System.out.println("주문이 완료되었습니다. 금액은 W: " + totalPrice+" 입니다.");
    }

    public boolean checkCartEmpty(){
        return cartList.isEmpty();
    }
}
