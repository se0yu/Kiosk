import java.util.ArrayList;
import java.util.List;

public class Cart {

    public List<MenuItem> cartList = new ArrayList<>();

    public void printCartList(){
        System.out.println("[ Orders ]");
        for(MenuItem cartList : cartList){
            System.out.println(cartList.productName +" | "
                    + cartList.productPrice+" | "
                    + cartList.productInfo);
        }
    }
    public void cancelOrder(){
        cartList.clear();
    }
}
