import java.awt.*;
import java.io.IOException;

public abstract class Car extends Vehicle  {      // Abstrakt klass som implementerar interfacet movable

    private int nrDoors; // Number of doors on the car

    /**
     * Konstruktor för Car objekt, ärvs av subklasser.
     * @param color
     * @param enginePower
     * @param modelName
     * @param nrDoors
     */
    public Car(Color color, int enginePower, String modelName, int nrDoors){
        super(color, enginePower, modelName);
        this.nrDoors = nrDoors;
    }

    /**
     *
     * @param nrDoors antal dörrar vi vill sätta
     */
    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    /**
     *
     * @return antal dörrar som en int
     */
    protected int getNrDoors() {
        return this.nrDoors;
    }

    protected abstract double speedFactor();
    /**
     * Ökar speed till högst 'enginePower'
     * @param amount mängden som vi vill öka med
     */
    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }
    /**
     * Minskar speed till minst '0'
     * @param amount mängden som vi vill minska med
     */
    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }
}