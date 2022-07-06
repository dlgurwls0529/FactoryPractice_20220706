package BasicFactory;

public class Client {
    public static void main(String[] args) {
        System.out.println("test");
        // 상속을 통해 하나의 상위 타입이 있고, 그것에 의존하는 다양한 클래스가 있다고 하자
        // 예를 들어 배를 만드는 것을 상상해보자
        // 처음에 하얀배를 만들고 나서, 그것이 잘 되면
        // 검은 배나, 빨간 배 등 다양한 것들을 만들어야 하게 된다.
        // 보통 조건(색깔)을 받아서 if 문을 통해 각각을 리턴한다.
        /*
        if(color.equals("white"))
            return WhiteShip();
        else if(color.equals("Red"))
            return RedShip();
        */
        // 하지만, 이는 조건이 추가(노란 배)되면 복잡한 if else 를
        // 수정해야 한다. 이는 객체 지향 원칙 OCP 에 위배된다.
        // 이를 충족시키고 유연한 구조로 개선한 것이 팩토리 메소드 패턴이다.

        // 팩토리 메소드 패턴이란, 객체를 생성할 때 구체적으로
        // 어떤 것을 만들지 정하는 것을 서브클래스에 위임하는 것이다.
        // Factory 인터페이스로 객체를 리턴하는 추상 메소드를 선언하고
        // ConcreteFactory(서브클래스) 에서 그것을 구현한다.

        // 이를 통해서 새로운 요구사항이 발생하였을 때, 기존 클래스
        // 를 수정하는 것이 아니라 새로운 클래스(+팩토리)를
        // 추가하는 것만으로 처리가 가능해진다.
        // 하지만, 이 과정에서 각 Product 생성 과정을
        // 위임하기 위해 많은 수의 서브클래스가 만들어진다는 단점이 있다.

        // OCP(Open Closed Principal) 란 객체지향 5대 원칙 중 하나로,
        // 어떤 코드 수정 작업을 할 때, 클래스 단위에서,
        // 기존의 코드를 변경하는 것을 지양하고, 확장되는 방향으로
        // 이루어져야 한다는 것이다.
        // OCP 를 만족하는 디자인은 클래스 간의 결합도를 낮출 수 있다. (loosely coupled)
        // 왜냐하면, 수정 작업에서 기존 클래스를 안 건드리기 때문에
        // 수정에 의한 연쇄 오류가 발생하지 않기 때문이다.

        // DIP 도 지킬 수 있다는데, 난 잘 모르겠다.

        // 이것을 구현하는 방법은 버전마다 다르다.
        // 그것은 자바 8 에서 추가된 인터페이스 default 메소드와
        // 자바 9 에서 추가된 인터페이스 private 메소드의 추가로 인해 달라진다.
        // 두 메소드의 공통점은 모두 인터페이스에 구현체를 만들 수 있다는 점이고
        // 차이점은 하위 클래스에서 호출이 가능(default), 호출이 불가능(private)가 있다.

        // 8 버전에서는 private 메소드가 없으니
        // 인터페이스 - 추상클래스(private 메소드 구현) - 구상클래스로 구현한다.

        // 7 버전 이하에서는 default 메소드도 없어서
        // 인터페이스(전부 추상메서드) - 추상클래스(default, private 전부 구현) - 구상클래스로 구현한다.

        // 9 이상에서는 그냥 추상클래스 역할을 인터페이스가 대신한다.

        Turtle easternHermanTurtle = new EasternHermanTurtleFactory().createTurtle();
        easternHermanTurtle.introduce();

        Turtle aldabraTurtle = new AldabraTurtleFactory().createTurtle();
        aldabraTurtle.introduce();

        // Dependency injection
        // 위 예제에서는 내부 클래스(Client)에서
        // Turtle 과 Factory 의 의존 관계를 결정했다.
        // (Factory 가 변함에 따라 Turtle 이 영향받음,
        // 즉, Turtle 이 Factory 에 의존한다.)
        // (동헤르만인지 알다브라인지)
        // 반면 아래 예제는 외부 클래스(외부는 아니지만 외부라고 하자)
        // 에다가 함수 인자를 통해 의존 관계를 주입한다.
        // 이처럼 외부에서 해당 클래스의 의존 관계를 결정하도록 하는 것을
        // 의존성 (외부) 주입 (DI)라고 한다.
        // 자세한건 모르겠다.
        // https://tecoble.techcourse.co.kr/post/2021-04-27-dependency-injection/

        ExternClass.introduceDI(new EasternHermanTurtleFactory());
        ExternClass.introduceDI(new AldabraTurtleFactory());

    }

}
