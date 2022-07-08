package DependencyInjectionBefore;

public class ClientB {

    private ShipFactory shipFactory;

    public ShipFactory getShipFactory() {
        return shipFactory;
    }

    public void setShipFactory() {
        this.shipFactory = new WhiteShipFactory();
    }

}
