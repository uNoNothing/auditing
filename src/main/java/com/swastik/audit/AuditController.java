package com.swastik.audit;

import java.util.ArrayList;
import java.util.List;

import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.core.json.JsonConverter;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swastik.user.User;

@RestController
@RequestMapping(value = "/audit")
public class AuditController {

    private static final Logger logger = LoggerFactory.getLogger(AuditController.class);

    @Autowired
    private Javers javers;

    @RequestMapping("/user/snapshots")
    public String getUserSnapshots() {
	logger.info("/user/snapshots GET");
	QueryBuilder jqlQuery = QueryBuilder.byClass(User.class);

	List<CdoSnapshot> changes = new ArrayList<CdoSnapshot>(javers.findSnapshots(jqlQuery.build()));

	changes.sort((o1, o2) -> -1
		* o1.getCommitMetadata().getCommitDate().compareTo(o2.getCommitMetadata().getCommitDate()));

	JsonConverter jsonConverter = javers.getJsonConverter();

	return jsonConverter.toJson(changes);
    }

    @RequestMapping("/user")
    public String getPersonChanges() {
	logger.info("/user GET");
	QueryBuilder jqlQuery = QueryBuilder.byClass(User.class);

	List<Change> changes = javers.findChanges(jqlQuery.build());

	changes.sort((o1, o2) -> -1
		* o1.getCommitMetadata().get().getCommitDate().compareTo(o2.getCommitMetadata().get().getCommitDate()));

	JsonConverter jsonConverter = javers.getJsonConverter();

	return jsonConverter.toJson(changes);
    }

}
