import com.kotlin.demo02.Latitude;

public class JavaDemo01 {
    public void test(){
        System.out.println("===JavaDemo01===");
    }

    public static void main(String[] args) {
        JavaDemo01 demo01 = new JavaDemo01();
        demo01.test();
        Latitude latitude = Latitude.ofDouble(2.0);
        System.out.println(latitude.getValue() + "---" + Latitude.TAG);
    }
}
