public class BigFiveTrait extends Trait implements Comparable {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int compare(Trait othetTrait) {
        return 0;
    }
}
