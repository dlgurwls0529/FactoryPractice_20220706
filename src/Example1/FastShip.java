package Example1;

public class FastShip extends Ship {

    private int speed;

    @Override
    void checkAttribute() {
        System.out.println("- name : " + this.getName());
        System.out.println("- color : " + this.getColor());
        System.out.println("- number : " + this.getNumber());
        System.out.println("- speed : " + this.getNumber());
    }

    public FastShip(String name) {
        super(name);
        this.setColor("black");
        this.setNumber(Math.abs((int)System.currentTimeMillis()));
    }
}
