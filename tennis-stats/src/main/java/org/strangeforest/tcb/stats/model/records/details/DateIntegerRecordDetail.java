package org.strangeforest.tcb.stats.model.records.details;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import static java.lang.String.*;

public class DateIntegerRecordDetail extends IntegerRecordDetail {

	private final Date date;

	public DateIntegerRecordDetail(
		@JsonProperty("value") int value,
		@JsonProperty("date") Date date
	) {
		super(value);
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	@Override public String toString() {
		return format("%1$d (%2$td-%2$tm-%2$tY)", getValue(), date);
	}
}
