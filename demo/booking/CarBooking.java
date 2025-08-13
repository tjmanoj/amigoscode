package amigoscode.demo.booking;

import amigoscode.demo.car.Car;
import amigoscode.demo.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class CarBooking {
	UUID bookingId;
	User user;
	Car car;
	LocalDateTime bookedTime;

	public CarBooking(UUID bookingId, User user, Car car, LocalDateTime bookedTime)
	{
		this.bookingId = bookingId;
		this.user = user;
		this.car = car;
		this.bookedTime = bookedTime;
	}

	@Override public String toString()
	{
		return "CarBooking{" +
			"bookingId=" + bookingId +
			", user=" + user +
			", car=" + car +
			", bookedTime=" + bookedTime +
			'}';
	}
}
