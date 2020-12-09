import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.*;
import static java.lang.Math.pow;

public abstract class Transport extends Vehicle {

    /**
     * Instansvariabler
     */
    private boolean rampUp;
    protected ArrayList<Car> carsLoaded;
    protected int capacity;

    /**
     * Konstruktor som initialiserar parametrarna med anrop till superklassen samt i den enskilda klassens konstruktor.
     * @param color
     * @param enginePower
     * @param modelName
     */
    public Transport(Color color, int enginePower, String modelName, int capacity) {
        super(color, enginePower, modelName);
        this.capacity = capacity;
        rampUp = true;
        carsLoaded = new ArrayList<Car>();
    }

    /**
     * Getter som returnerar listan med lastade bilar.
     * @return
     */
    public ArrayList<Car> getCarsLoaded() {
        return carsLoaded;
    }

    /**
     * En metod som fäller ner rampen sålänge fordonen inte är i rörelse.
     */
    public void setRampDown() {
        if(this.getCurrentSpeed() == 0)
            this.rampUp = false;
        else
            System.out.println("Transport is moving");
    }

    /**
     * En metod som fäller upp rampen.
     */
    public void setRampUp(){
        this.rampUp = true;
    }

    /**
     * @return Returnerar om rampen är uppe eller ej i en boolean.
     */
    public boolean getRampUp() {
        return this.rampUp;
    }

    /**
     * Metod som returnerar avståndet från transporten till bilen som skall lastas mha pyth-sats.
     * @param carToLoad
     * @return
     */
    public double checkDistance(Car carToLoad) {
        double deltaX = abs(this.getLocation().x) - carToLoad.getLocation().x;
        double deltaY = abs(this.getLocation().y) - carToLoad.getLocation().y;

        return sqrt(pow(deltaX, 2) + pow(deltaY, 2));
    }

    /**
     * Abstrakt metod som implementeras av subklasser. Tar ett Car objekt som 'parameter'
     * @param carToLoad
     */
    public abstract void loadCar(Car carToLoad);

    /**
     * Abstrakt metod som implementeras av subklasser. Lastar av bil/bilar.
     */
    public abstract void unloadCar();

    /**
     * En överskrivning av move metoden så att lastbilen inte kan köra när rampen är nere.
     */
    @Override
    public void move() {
        if (this.rampUp){
            super.move();
            for(Car car : carsLoaded){
                car.setLocation(this.getLocation().x, this.getLocation().y);
            }
        }
        else
            System.out.println("Ramp is not up");
    }
}
