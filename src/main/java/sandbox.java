import java.util.List;

/*
class DvdDatabase  {
    public List<String> dvdTitles;

    DvdDatabase(List<String> dvdTitles)  {
        this.dvdTitles = dvdTitles;
    }

    public List<String> getDvdTitles()  {
        return dvdTitles;
    }
}

// first solution: using an abstract class
abstract class DvdDatabase1{
    abstract List<String> getDvdTitles();
}

class Dvddatabase_first extends DvdDatabase1 {
    private  List<String> dvdTitles;

    @Override
    public List<String> getDvdTitles() {
        return dvdTitles;
    }
}

// second solution: using an interface
interface DvdDatabase2 {
    List<String> getDvdTitles();
}

class DvdDatabase_second implements DvdDatabase2{
    private List<String> dvdTitles;

    @Override
    public List<String> getDvdTitles() {
        return null;
    }
}

// third solution: using getter and setter
class DvdDatabase3{
    private List<String> dvdTitles;

    public List<String> getDvdTitles() {
        return dvdTitles;
    }

    public void setDvdTitles(List<String> dvdTitles) {
        this.dvdTitles = dvdTitles;
    }
}

// fourth solution: make the field read-only
class DvdDatabase4  {
    private final List<String> dvdTitles = myPrivateList;

    public List<String> getDvdTitles()  {
        return dvdTitles;
    }
}


//polymorphism
class Car {
    public void displayCompany() {
        System.out.println("This is a method to display our car manufacturer");
    }
}

class Benz extends Car {
    public void displayCompany() {
        System.out.println("I'm a Car and I made by Benz, a German company ");
    }
}

class Elantra extends Car {
    public void displayCompany() {
        System.out.println("I'm a Car and I made by Hyundai, a Korean company");
    }
}


class Lexus extends Car {
    public void displayCompany() {
        System.out.println("I'm a Car and I made by Toyota, a Japanese company");
    }
}


class Main {
    public static void main(String[] args) {
        Car newCar1 = new Car();
        Car newCar2 = new Benz();
        Car newCar3 = new Elantra();
        Car newCar4 = new Lexus();


        newCar1.displayCompany();
        newCar2.displayCompany();
        newCar3.displayCompany();
        newCar4.displayCompany();

    }
}
*/