package Adapter;


public class FishingBoatExten implements RowingBoat {

	private final FishingBoat boat;

	public FishingBoatExten() {
		boat = new FishingBoat();
	}

	@Override
	public void row() {
		boat.sail();
	}
}