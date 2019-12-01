package com.edeploy.online.hackz;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * 
 * @author Administrator
 *
 */
public class EntryPoint {

	
	/**
	 * 
	 */
	@Test
	public void start() {

		final List<Seat> listOf = Arrays.asList(new Seat(3, 2), new Seat(2, 0), new Seat(0, 2), new Seat(3, 3), new Seat(2, 2));

		this.receiveSeatMap(new SeatMap(listOf))
			.forEach(out::println);

	}

	/**
	 * 
	 * @param seats
	 * @return
	 */
	private List<List<Seat>> receiveSeatMap(SeatMap seats) {

		return seats.listOfseats
				.stream()
					.sorted(Comparator.comparing(Seat::getX))
					.collect(Collectors.groupingBy(Seat::getY))
					.entrySet()
						.stream()
					.map(mapper -> mapper.getValue())
				.collect(Collectors.toList());
	}

	@Data
	@AllArgsConstructor
	final class SeatMap {

		
		private List<Seat> listOfseats;

	}

	@Data
	@AllArgsConstructor
	final class Seat {
		private int x;
		private int y;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("(x=%d,y=%d)", x, y);
		}

	}

}
