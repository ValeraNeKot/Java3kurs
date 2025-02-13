import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persone> pers = new ArrayList<>();
        pers.add(new Persone("Семенова", true, 20));
        pers.add(new Persone("Иванов", false, 24));
        pers.add(new Persone("Петров", false, 16));
        pers.add(new Persone("Сидоров", false, 13));
        pers.add(new Persone("Курачева", true, 19));
        WriteInfo tz= new WriteInfo();
        tz.AveM(pers);
    }
}