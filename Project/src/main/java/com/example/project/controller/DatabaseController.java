package com.example.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DatabaseController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @DeleteMapping("/clear-database")
    public String clearDatabase() {
        // Fetch all collection names
        for (String collectionName : mongoTemplate.getCollectionNames()) {
            if (!collectionName.startsWith("system.")) {  // Avoid dropping system collections
                // Drop each collection
                mongoTemplate.dropCollection(collectionName);
            }
        }
        return "All collections in database cleared.";
    }
}
