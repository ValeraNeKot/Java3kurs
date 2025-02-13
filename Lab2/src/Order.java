import java.util.HashMap;

public class Order implements Printable{
    private HashMap<Dish, Integer> list;

    public Order(){
        list= new HashMap<>();
    }
    public Order(HashMap<Dish, Integer> list, int totalPrice) {
        this.list = list;

    }
public void orderDish(Menu menu, String title){
    if (menu == null) {
        System.out.println("Меню пустое");
        return;
    }
    list.put(menu.searchDish(title), list.getOrDefault(menu.searchDish(title), 0) + 1);
}
    public void print(){
        int totalPrice=0;
        System.out.println("Ваш заказ:");
        System.out.println("--------------------------");
        for (HashMap.Entry<Dish, Integer> entry : list.entrySet()) {
            System.out.println(entry.getKey() + "кол-во " + entry.getValue());
            totalPrice+= entry.getValue() * entry.getKey().getPrace();
        }
        System.out.println("--------------------------");
        System.out.println("Итоговая цена: "+ totalPrice);
    }
}
