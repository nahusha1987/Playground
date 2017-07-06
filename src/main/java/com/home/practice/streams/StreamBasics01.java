package com.home.practice.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.home.practice.lambdas.Trade;

/**
 * @author nahusha
 *
 */
public class StreamBasics01 {

	private void findLargeTradesUsingStreams(List<Trade> trades) {
		trades.stream().filter(Trade::isCancelledTrade).collect(Collectors.toList()).forEach(System.out::println);;
	}
	
	public static void main(String[] args) {
		List<Trade> trades = new ArrayList<>();
		trades.add(new Trade());
		trades.add(new Trade());
		trades.add(new Trade());
		System.out.println(trades.size());
		new StreamBasics01().findLargeTradesUsingStreams(trades);
	}

}
