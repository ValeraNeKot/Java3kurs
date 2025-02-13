package lab3;

import java.util.Objects;

public class DrinkingYogurt extends Yogurt {
	private int containerVolume;
	private String flavorAdditive;
	
	public int getContainerVolume() {
		return containerVolume;
	}
	public void setContainerVolume(int containerVolume) {
		this.containerVolume = containerVolume;
	}
	public String getFlavorAdditive() {
		return flavorAdditive;
	}
	public void setFlavorAdditive(String flavorAdditive) {
		this.flavorAdditive = flavorAdditive;
	}

	@Override
	public double calories() {
		return (super.getProtein()*4+ super.getFat()*9)/100*containerVolume;
	}
	@Override
	public int hashCode() {
		return Objects.hash(containerVolume, flavorAdditive);
	}
	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DrinkingYogurt other = (DrinkingYogurt) obj;
		return containerVolume == other.containerVolume && Objects.equals(flavorAdditive, other.flavorAdditive);
	}
	@Override
	public String toString() {
		return "DrinkingYogurt [containerVolume=" + containerVolume + ", flavorAdditive=" + flavorAdditive + "]";
	}
	
	public DrinkingYogurt() {
		super();
	}

	public DrinkingYogurt(String shelfLife, double protein, double fat, int containerVolume, String flavorAdditive) {
		super(shelfLife, protein, fat);
		this.containerVolume = containerVolume;
		this.flavorAdditive = flavorAdditive;
	}
	
}
