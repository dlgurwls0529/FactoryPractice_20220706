package Example1;

public class FastShipFactory implements ShipFactory {

    @Override
    public Ship createShip(String name) {
        return new FastShip(name);
    }
}
