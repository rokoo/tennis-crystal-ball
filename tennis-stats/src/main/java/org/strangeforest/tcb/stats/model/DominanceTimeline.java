package org.strangeforest.tcb.stats.model;

import java.util.*;

import org.strangeforest.tcb.stats.model.core.*;

import com.google.common.collect.*;

public class DominanceTimeline {

	private final Surface surface;
	private final List<PlayerDominanceTimeline> players;
	private final SortedSet<Integer> seasons;
	private List<DominanceSeason> dominanceSeasons;
	private List<DominanceEra> dominanceEras;

	public DominanceTimeline(Surface surface) {
		this.surface = surface;
		players = new ArrayList<>();
		seasons = new TreeSet<>(Comparator.reverseOrder());
	}

	public List<PlayerDominanceTimeline> getPlayers() {
		return players;
	}

	public Collection<Integer> getSeasons() {
		return seasons;
	}

	public List<DominanceSeason> getDominanceSeasons() {
		return dominanceSeasons;
	}

	public DominanceSeason getDominanceSeason(int season) {
		for (DominanceSeason dominanceSeason : dominanceSeasons) {
			if (dominanceSeason.getSeason() == season)
				return dominanceSeason;
		}
		return null;
	}

	public List<DominanceEra> getDominanceEras() {
		return dominanceEras;
	}

	public void addPlayer(PlayerDominanceTimeline player) {
		players.add(player);
		seasons.addAll(player.getSeasons());
		player.setTimeline(this);
	}

	public void calculateDominanceSeasons() {
		dominanceSeasons = new ArrayList<>(seasons.size());
		for (Integer season : seasons) {
			DominanceSeason dominanceSeason = new DominanceSeason(season, surface);
			for (PlayerDominanceTimeline player : players)
				dominanceSeason.processPlayer(player);
			dominanceSeasons.add(dominanceSeason);
		}
	}

	public void calculateDominanceEras() {
		int seasonCount = dominanceSeasons.size();
		for (int i = 0; i < seasonCount; i++) {
			DominanceSeason dominanceSeason = dominanceSeasons.get(i);
			if (dominanceSeason.isEligibleForEra()) {
				PlayerDominanceTimeline bestPlayer = dominanceSeason.getBestPlayer();
				PlayerDominanceTimeline prevBestPlayer = i > 0 ? getAdjacentSeasonBestPlayer(i - 1) : null;
				PlayerDominanceTimeline nextBestPlayer = i < seasonCount - 1 ? getAdjacentSeasonBestPlayer(i + 1) : null;
				dominanceSeason.setEraPlayer(prevBestPlayer == null || prevBestPlayer != nextBestPlayer ? bestPlayer : prevBestPlayer);
			}
		}
		dominanceEras = new ArrayList<>();
		List<DominanceSeason> eraSeasons = null;
		for (DominanceSeason dominanceSeason : dominanceSeasons) {
			if (eraSeasons != null && dominanceSeason.getEraPlayer() != eraSeasons.get(0).getEraPlayer()) {
				dominanceEras.add(new DominanceEra(eraSeasons));
				eraSeasons = null;
			}
			if (eraSeasons == null)
				eraSeasons = new ArrayList<>();
			eraSeasons.add(dominanceSeason);
		}
		if (eraSeasons != null)
			dominanceEras.add(new DominanceEra(eraSeasons));
	}

	private PlayerDominanceTimeline getAdjacentSeasonBestPlayer(int seasonIndex) {
		DominanceSeason prevSeason = dominanceSeasons.get(seasonIndex);
		return !prevSeason.isOngoingSeason() ? prevSeason.getBestPlayer() : null;
	}

	public DominanceTimeline filterSeasons(Range<Integer> seasonRange) {
		if (seasonRange.equals(Range.all()))
			return this;
		DominanceTimeline timeline = new DominanceTimeline(surface);
		for (PlayerDominanceTimeline player : players) {
			player = player.filterSeasons(seasonRange);
			if (player.hasSeasons())
				timeline.addPlayer(player);
		}
		timeline.calculateDominanceSeasons();
		timeline.calculateDominanceEras();
		for (DominanceSeason dominanceSeason : timeline.getDominanceSeasons()) {
			DominanceSeason season = getDominanceSeason(dominanceSeason.getSeason());
			if (season != null) {
				dominanceSeason.setPredictability(season.getPredictability());
				dominanceSeason.setEloPredictability(season.getEloPredictability());
				dominanceSeason.setAverageEloRatings(season.getAverageEloRatings());
			}
		}
		return timeline;
	}


	// Util

	static int roundDominanceRatio(double dominanceRatio) {
		return 10 * ((int)dominanceRatio / 10);
	}
}
