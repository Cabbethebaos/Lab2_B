import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Vehicle implements Movable {

    private Color color; // Color of the car
    private String modelName; // The car model name
    private double currentSpeed; // The current speed of the car
    private double enginePower; // Engine power of the car
    private int dirr; //0 = north, 1=east, 2=south, 3=west
    private boolean engineOn; // Anger om fordonets motor är på
    private Point location; // location stored as a point
    private int offset = 0; // int thats holds offset variable

    private Direction dir;

    public Vehicle(Color color, int enginePower, String modelName) {
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();

        dir = new Direction();

        this.location = new Point(0, offset);
        offset += 100;

    }

    /**
     * metod som vänder bilen, gör på detta viset för att den ska vara immutable
     */
    public void turnAround(){
        dir.turnAround();
    }

    /**
     * returnerar en int som lagrar direction
     * @return
     */
    public int getDir(){
        return dir.getDir();
    }

    /**
     * Returnerar en point med hänsyn till mutabilitet
     * @return
     */
    public Point getLocation(){
        return new Point(this.location);
    }
    public void setLocation(Point newLocation){
        this.location = new Point(newLocation);
    }

    public Point setLocation(int x, int y){
        return new Point(x,y);
    }

    /**
     * Returnerar true/false beroende om motorn på/av
     * @return
     */
    public boolean isEngineOn() {
        return engineOn;
    }

    /**
     *
     * @return modellnamnet
     */
    public String getModelName() {
        return modelName;
    }

    /**
     *
     * @param modelName sätter modellnamn
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }


    /**
     *
     * @return vilken dirr bilen pekar
     */
    public int getDirr() {
        return dirr;
    }

    /**
     *
     * @param dirr sätter direction
     */
    public void setDirr(int dirr) {
        this.dirr = dirr;
    }

    /**
     *
     * @param enginePower hk som vi vill sätta
     */
    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     *
     * @return enginepower som en double
     */
    protected double getEnginePower() {
        return this.enginePower;
    }

    /**
     *
     * @return nuvarande hastighet i double
     */
    protected double getCurrentSpeed() {
        return this.currentSpeed;

    }

    /**
     *
     * @return färgen som en color
     */
    protected Color getColor() {
        return this.color;
    }

    /**
     *
     * @param clr anger en color som ska sättas
     */
    protected void setColor(Color clr) {
        this.color = clr;
    }

    /**
     * startar motorn och sätter currentspeed till 0.1
     */
    protected void startEngine() {
        this.engineOn = true;
        this.currentSpeed = 0.1;
    }

    /**
     * stänger av motorn och sätter hastighet till 0
     */
    protected void stopEngine() {
        this.engineOn = false;
        this.currentSpeed = 0;
    }

    /**
     * Ökar speed till högst 'enginePower'
     * @param amount mängden som vi vill öka med
     */
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + amount, enginePower);
    }

    /**
     * Minskar speed till minst '0'
     * @param amount mängden som vi vill minska med
     */
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - amount, 0);
    }

    /**
     *  Som incrementSpeed fast tar endast specifika värden
     * @param amount mellan 0 och 1 hur mkt vi vill gasa
     * Eftersom vi endast tillåter värden mellan 0 och 1 kan bilen inte bromsas av denna funktion
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1 )
            if(engineOn)
                incrementSpeed(amount);
            else
                System.out.println("Engine is turned off!");
        else
            System.out.println("invalid number!");
    }

    /**
     *  Som decrementSpeed fast tar endast specifika värden
     * @param amount mängden vi vill bromsa med
     *  Eftersom vi endast tillåter värden mellan 0 och 1 kan bilen inte öka farten av denna funktion
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
        else
            throw new RuntimeException("invalid number");
    }

    /**
     *  Rör sig i den riktningen som bilen pekar med nuvarande hastighet
     */
    public void move() {
        if (dir.getDir() == 0) {
            location.y += this.getCurrentSpeed();
        } else if (dir.getDir() == 1) {
            location.x += this.getCurrentSpeed();
        } else if (dir.getDir() == 2) {
            location.y -= this.getCurrentSpeed();
        } else location.x -= this.getCurrentSpeed();
    }

    /**
     *
     * @param speed värdet som hastigheten ska sättas till
     */
    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }
}
