package Adapter;

public final class Client {

	  private Client() {
	  }

	  /**
	   * Program entry point.
	   *
	   * @param args command line args
	   */
	  public static void main(final String[] args) {
	    // The captain can only operate rowing boats but with adapter he is able to
	    // use fishing boats as well
	    Captain captain = new Captain(new FishingBoatExten());
	    captain.row();
	  }
	}