package comp3111.covid;

import java.time.LocalDate;

public class Statistic<T> {
	private T value;
	private LocalDate date;

	/**
	 * Constrctor of statistic with a value and date
	 * @param value
	 * @param date
	 */
	public Statistic(T value, LocalDate date) {
		this.value = value;
		this.date = date;
	}
	public Statistic(T value) {
		this.value = value;
		this.date = null;
	}
	public T getValue() {
		return value;
	}
	public LocalDate getDate() {
		return date;
	}
}