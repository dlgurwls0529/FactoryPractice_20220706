package Example1;

public class Client {
    public static void main(String[] args) {
        Ship blackShip = new BlackShipFactory().orderShip("maverick", "dlgurwls0529@gmail.com");
        blackShip.checkAttribute();

        Ship whiteShip = new WhiteShipFactory().orderShip("tomcat", "dlgurwls0529@gmail.com");
        whiteShip.checkAttribute();
    }
}
