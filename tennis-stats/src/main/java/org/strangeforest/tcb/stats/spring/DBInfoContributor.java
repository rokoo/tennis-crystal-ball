package org.strangeforest.tcb.stats.spring;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.actuate.info.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;
import org.strangeforest.tcb.stats.service.*;

import static org.strangeforest.tcb.util.DateUtil.*;

@Component
@Profile("!dev")
public class DBInfoContributor implements InfoContributor {

	@Autowired private DataService dataService;

	@Value("${tennis-stats.database-name:postgres}")
	private String databaseName;

	@Override public void contribute(Info.Builder builder) {
		builder.withDetail("db", Map.of(
			"version", dataService.getDBServerVersionString(),
			"size", dataService.getDatabaseSize(databaseName),
			"dataUpdate", formatDate(dataService.getDataUpdate())
		));
	}
}
