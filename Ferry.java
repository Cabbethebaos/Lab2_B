import java.awt.*;

public class Ferry extends Transport {

    /**
     * Konstruktor desslikt CarTransport
     * @param color
     * @param enginePower
     * @param modelName
     * @param capacity
     */
    public Ferry(Color color, int enginePower, String modelName, int capacity) {
        super(color, enginePower, modelName, capacity);
    }

    /**
     * Metod som lastar ett givet Car objekt.
     * @param carToLoad
     */
    @Override
    public void loadCar(Car carToLoad) {
        if (checkDistance(carToLoad) < 2 && !getRampUp() && carsLoaded.size() < capacity)
            carsLoaded.add(carToLoad);
        else
            System.out.println("Car can't be loaded");
    }

    /**
     * Metod som avlastar objektet som först lastades.
     */
    @Override
    public void unloadCar() {
        if (!getRampUp()) {
            Car temp = carsLoaded.get(0);
            temp.setLocation(this.getLocation().x, (this.getLocation().y + 1));
            carsLoaded.remove(0);
        }
        else
            System.out.println("Ramp is not down!");
    }

}
