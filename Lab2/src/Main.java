public class Main {
    public static void main(String[] args) {
        Menu m = new Menu();
        Order o = new Order();
        m.addDish(new Pasta("Макарошки",8,"Рожки"));
        m.addDish(new Cutlet("Котлетка", 14,"Свинина"));
        m.addDish(new MashedPotatoes("Пюрешка", 10,200));
        m.print();
        o.orderDish(m,"Котлетка");
        o.orderDish(m,"Котлетка");
        o.orderDish(m,"Пюрешка");
        o.print();
    }
}