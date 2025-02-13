package lab3;
import java.util.ArrayList;

public class Lab3 {

	public static void main(String[] args) {
	ArrayList <DairyProduct> product = new ArrayList<DairyProduct>();
	product.add(new Kefir("31.10.2015",3.6, 2.4, 250, 8));
	product.add(new Kefir("31.10.2015",3, 2, 100, 8));
	product.forEach((n) -> System.out.println(n));
	}
}
