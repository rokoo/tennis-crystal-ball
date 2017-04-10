package org.strangeforest.tcb.stats.model;

import java.util.*;

import static org.strangeforest.tcb.stats.util.PercentageUtil.*;

public class PlayerForecast extends MatchPlayerEx {

	private Map<String, Double> forecast;

	public PlayerForecast(int playerId, String name, Integer seed, String entry, String countryId) {
		super(playerId, name, seed, entry, countryId);
	}

	PlayerForecast(PlayerForecast player) {
		super(player);
	}

	public boolean isKnown() {
		return getName() != null;
	}

	public boolean isBye() {
		return getName() == null && getEntry() == null;
	}

	public boolean isQualifier() {
		return getName() == null && "Q".equals(getEntry());
	}

	public double getWinProbability() {
		Double probability = getProbability("W");
		return probability != null ? probability : 0.0;
	}

	public Double getProbability(String result) {
		if (isEmpty())
			return null;
		Double probability = forecast.get(result);
		return probability != null ? PCT * probability : null;
	}

	void addForecast(String result, double probability) {
		if (forecast == null)
			forecast = new HashMap<>();
		forecast.put(result, probability);
	}

	boolean isEmpty() {
		return forecast == null;
	}
	
	boolean hasAnyResult(Iterable<String> results) {
		if (isEmpty())
			return false;
		for (String result : results) {
			if (forecast.containsKey(result))
				return true;
		}
		return false;
	}
}