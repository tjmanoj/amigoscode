package org.example.booking;

import java.util.Arrays;

public class CarBookingDAO
{
	public static final int MAX_CAR_BOOKING = 10;
	private CarBooking[] carBookings;
	private int nextAvailableSlot = 0;
	private int totalBookings = 0;

	public CarBookingDAO()
	{
		this.carBookings = new CarBooking[MAX_CAR_BOOKING];
	}

	public void bookCar(CarBooking booking)
	{
		carBookings[nextAvailableSlot++] = booking;
		totalBookings++;
	}

	public CarBooking[] getCarBookings()
	{
		return carBookings;
	}

	public int getTotalBookings()
	{
		return totalBookings;
	}

	@Override public String toString()
	{
		return "CarBookingDAO{" +
			"carBookings=" + Arrays.toString(carBookings) +
			'}';
	}
}
