import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarModel extends JComponent {

    List<Vehicle> vehicles = new ArrayList<>();

    public CarModel(){
        this.vehicles.add(new Volvo240());
        this.vehicles.add(new Scania(Color.red, 278, "Scania"));
        this.vehicles.add(new Saab95());
    }

    public static void main(String[] args) {
        // Instance of this class
        CarModel carModel = new CarModel();
        CarController carController = new CarController(carModel);
        CarView carView = new CarView(carModel, carController);

        carModel.vehicles.add(new Volvo240());
        carModel.vehicles.add(new Scania(Color.red, 278, "Scania"));
        carModel.vehicles.add(new Saab95());

        // Start the timer
        carController.startTimer();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void start() {
        for (Vehicle car : vehicles)
            car.startEngine();
    }

    public void stop() {
        for (Vehicle car : vehicles)
            car.stopEngine();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles)
            car.gas(gas);

    }

    /**
     * Anropar BRAKE metoden för varje car i cars listan.
     * @param amount
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles)
            car.brake(brake);

    }

    /**
     * Sätter på turbon om Saab95
     */
    void turboOn() {
        for (Vehicle car : vehicles)
            if(car instanceof Saab95 )
                ((Saab95) car).setTurboOn();
    }

    /**
     * Stänger av på turbon om Saab95
     */
    void turboOff() {
        for (Vehicle v : vehicles)
            if(v instanceof Saab95 )
                ((Saab95) v).setTurboOff();
    }

    /**
     * Stänger av på turbon om Saab95
     */
    void liftBed() {
        for (Vehicle v : vehicles)
            if(v instanceof Scania )
                ((Scania) v).liftBed(45);
    }

    /**
     * Stänger av på turbon om Saab95
     */
    void lowerBed() {
        for (Vehicle v : vehicles)
            if(v instanceof Scania )
                ((Scania) v).lowerBed(45);
    }

}
