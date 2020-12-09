import java.awt.*;
import java.util.ArrayList;
import static java.lang.Math.*;

public class CarTransport extends Transport {
    /**
     * Konstruktor som initialiserar parametrarna med anrop till superklassen.
     * @param color
     * @param enginePower
     * @param modelName
     */
    public CarTransport(Color color, int enginePower, String modelName, int capacity) {
        super(color, enginePower, modelName, capacity);
    }

    /**
     * Metod som lastar ett givet Car objekt.
     * @param carToLoad anger
     */
    public void loadCar(Car carToLoad) {
        if (checkDistance(carToLoad) < 2 && !getRampUp() && carsLoaded.size() < capacity)
            carsLoaded.add(carToLoad);
        else
            System.out.println("Car can't be loaded");
    }

    /**
     * Metod som avlastar objektet som senast lastades.
     */
    public void unloadCar() {
        if (!getRampUp()) {
            Car temp = carsLoaded.get(carsLoaded.size() - 1);
            temp.setLocation(this.getLocation().x, (this.getLocation().y - 1));
            temp.setLocX(this.getLocX());
            temp.setLocY(this.getLocY() - 1);

            carsLoaded.remove(carsLoaded.size() - 1);
        }
        else
            System.out.println("Ramp is not down!");
    }
}

