import java.util.ArrayList;
import java.util.List;

public class MenuItem {

    //필드
    String productName;
    double productPrice;
    String productInfo;


    //생성자
    public MenuItem(String productName, double productPrice, String productInfo) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productInfo = productInfo;
    }

    //getter

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductInfo() {
        return productInfo;
    }
}
