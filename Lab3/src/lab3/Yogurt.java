package lab3;

import java.util.Objects;

abstract public class Yogurt implements DairyProduct, Print {
	private String shelfLife;
	private double protein;
	private double fat;
	
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	
	@Override
	public double calories() {
		return protein*4+ fat*9;
	}
	@Override
	public void print() {
		System.out.println(this);
	}
	@Override
	public int hashCode() {
		return Objects.hash(fat, protein, shelfLife);
	}
	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Yogurt other = (Yogurt) obj;
		return Double.doubleToLongBits(fat) == Double.doubleToLongBits(other.fat)
				&& Double.doubleToLongBits(protein) == Double.doubleToLongBits(other.protein)
				&& Objects.equals(shelfLife, other.shelfLife);
	}
	@Override
	public String toString() {
		return "Yogurt [shelfLife=" + shelfLife + ", protein=" + protein + ", fat=" + fat + ", calories()=" + calories()
				+ "]";
	}
	public Yogurt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Yogurt(String shelfLife, double protein, double fat) {
		super();
		this.shelfLife = shelfLife;
		this.protein = protein;
		this.fat = fat;
	}
	
	
}
