import java.util.Objects;

abstract public class Dish {
    private String title;
    private int prace;

    public int getPrace() {
        return prace;
    }
    public String getTitle() {
        return title;
    }

    public void setPrace(int prace) {
        this.prace = prace;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Dish(){
        title = new String();
        prace = 0;
    }

    @Override
    public String toString() {
        return  title + ", "+ prace;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Dish dish = (Dish) o;
        return prace == dish.prace && Objects.equals(title, dish.title);
    }

    @Override
    public int hashCode() {
        int result =  title.hashCode();
        result = 31 * result + prace;
        return result;
    }
}
