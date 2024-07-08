package study.uml.class_diagram;

public class Car {

  Insurance insurance;
  Navigation navigation;
  Engine engine;

  public Car(Engine engine) {
    this.engine = engine;
  }

  public Insurance getInsurance() {
    return insurance;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

  public Navigation getNavigation() {
    return navigation;
  }

  public void setNavigation(Navigation navigation) {
    this.navigation = navigation;
  }

  public Engine getEngine() {
    return engine;
  }

  public void fuelUp(GasStation gasStation) {
    gasStation.inject();
  }


}
