import java.util.ArrayList;
import java.util.List;

public class Cart {

    public List<MenuItem> cartList = new ArrayList<>();
    public double sumPrice;
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

    public void orderCart(int selectNum){
        switch (selectNum){
            case 1 -> {
                System.out.println("주문이 완료 되었습니다. 금액은 W "+ sumPrice+" 입니다.");
                cartList.clear();
            }
            case 2 -> System.out.println("메뉴로 돌아갑니다.");
            default -> System.out.println("잘못된 입력입니다.");
        }
    }


    public void cancelOrder(){
        System.out.println("주문이 취소 되었습니다. 메뉴로 돌아갑니다.");
        cartList.clear();
    }
}
