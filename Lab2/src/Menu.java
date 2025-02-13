import java.util.HashSet;

public class Menu implements Printable {
    private HashSet<Dish> list;

    public HashSet<Dish> getList() {
        return list;
    }

    public void setList(HashSet<Dish> list) {
        this.list = list;
    }
public Menu(){
        list = new HashSet<>();
}
    public void addDish(Dish d){
        list.add(d);
    }
public Dish searchDish(String title){
    for (Dish dish : list){
        if(dish.getTitle().equals(title))  return dish;
    }
    return null;
}
    public void deleteDish(String title){
        list.removeIf(dish -> dish.getTitle().equals(title));
        //for (Dish dish : list){
        //    if(dish.getTitle().equals(title))  list.remove(dish);
        //}
    }

    public void print(){
        if (list == null) {
            System.out.println("Меню пустое");
            return;
        }
        System.out.println("Сегодня в меню: ");
        System.out.println("--------------------------");
        list.forEach(System.out::println);
        System.out.println();
    }
}
