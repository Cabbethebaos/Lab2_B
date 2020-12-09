import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Saab95 saabalada = new Saab95();

        saabalada.setTurboOn();
        saabalada.startEngine();
        saabalada.incrementSpeed(10);
        saabalada.move();
        System.out.println(saabalada.getLocation().y);

        saabalada.gas(0.2);

        saabalada.incrementSpeed(4);

        System.out.println(saabalada.getCurrentSpeed());


        Scania lastbil = new Scania(Color.red, 350, "143H");

        lastbil.move();

        lastbil.setCurrentSpeed(31);
        lastbil.liftBed(30);
        lastbil.move();
        lastbil.lowerBed(31);

        CarTransport lastare = new CarTransport(Color.green, 420, "hjullastare", 10);
        Volvo240 v240 = new Volvo240();
        lastare.setRampDown();
        lastare.loadCar(v240);
        lastare.unloadCar();
        System.out.println(v240.getLocation().x + ", " + v240.getLocation().y);

        Workshop<Volvo240> volvo240Workshop = new Workshop<>(5);
        volvo240Workshop.addToWorkshop(v240);
        volvo240Workshop.addToWorkshop(v240);

        volvo240Workshop.removeFromWorkshop(v240);

        System.out.println(volvo240Workshop.getBrokenCars());

        Volvo240 v244 = new Volvo240();
        Volvo240 v245 = new Volvo240();

        Workshop<Car> carWorkshop = new Workshop<>(3);
        carWorkshop.addToWorkshop(v240);
        carWorkshop.addToWorkshop(v244);
        carWorkshop.addToWorkshop(v245);
        carWorkshop.addToWorkshop(saabalada);

        System.out.println(carWorkshop.getBrokenCars());

    }


}