package com.example.ch4;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;

// Write your answer here, and then test your code.
// Your job is to implement the findAnswer() method and the FactorialTask class.

class Answer {

	// Change these boolean values to control whether you see
	// the expected result and/or hints.
	static boolean showExpectedResult = false;
	static boolean showHints = false;

	static Map<Integer, BigInteger> findAnswer(List<Integer> numbers) {
		// Your code goes here.
		Map<Integer, BigInteger> result = new HashMap<>();
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < numbers.size(); i++) {
			FactorialTask task = new FactorialTask(numbers.get(i));
			try {
				Future<Map.Entry<Integer, BigInteger>> mapItem = executor.submit(task);
				result.put(mapItem.get().getKey(), mapItem.get().getValue());
			} catch (InterruptedException | RuntimeException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		return result;
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25, 30);
		Map<Integer, BigInteger> result = Answer.findAnswer(numbers);
		Long startTime = System.currentTimeMillis();
		System.out.println();
		for ( Map.Entry<Integer, BigInteger> entry : result.entrySet()) {
			System.out.println("Factorial of " + entry.getKey() + " is " + String.format("%,d", entry.getValue()));
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("\nElapsed time: " + (endTime - startTime) + " ms");
	}
}

class FactorialTask implements Callable<Map.Entry<Integer, BigInteger>> {
	// Some of your code goes here
	private final int number;
	public FactorialTask(int number) {
		// Your code goes here.
		this.number = number;
	}
	@Override
	public Map.Entry<Integer, BigInteger> call() throws Exception {
		// Your code goes here.
		BigInteger factorial = BigInteger.ONE;
		for (int i = 1; i <= number; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return new AbstractMap.SimpleEntry<Integer, BigInteger>(number, factorial);
	}
}

