package github.vikram.mockito.model;

public class CarManager {

	public static CarSummary convertCarSummary(Car car) {
		CarSummary cs = new CarSummary();
		cs.setMake(car.getMake());
		cs.setMiles(car.getMiles());
		return cs;
	}

}
