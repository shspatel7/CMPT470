package headfirst.state.gumballstate;

public class MaintenanceState implements State {
    GumballMachine gumballMachine;

    public MaintenanceState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    private int maintenanceGumballCount;

    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    public void ejectQuarter() {
        System.out.println("Sorry, we're in maintenance mode");
    }

    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    public void dispense() {
        System.out.println("Now dispensing the gumballs.......");
        maintenanceGumballCount = gumballMachine.getCount();
        if (gumballMachine.getCount() > 0){
            while (gumballMachine.getCount() != 0) {
                gumballMachine.releaseBall();
            }
            System.out.println("All gumballs are now dispensed");
            refill();
        }
        else {
            System.out.println("No gumballs to dispense");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }            
    }

    public void refill() {
        System.out.println("Refilling gumballs.......");
        if (maintenanceGumballCount > 0) {
            gumballMachine.refill(maintenanceGumballCount);
            System.out.println("Refilled " + maintenanceGumballCount + " gumballs.");
        }
        else {
            System.out.println("No gumballs to refill");
        }
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    public String toString() {
        return "is in maintenance state.";
    }

}