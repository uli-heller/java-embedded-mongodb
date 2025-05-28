package com.example;

//https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo.spring/blob/main/HowTo.md

import org.assertj.core.api.Assertions;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

@DataMongoTest()
@TestPropertySource(properties = {
        "de.flapdoodle.mongodb.embedded.version=8.0.3",
        "de.flapdoodle.mongodb.embedded.databaseDir=mongodb-dir"
})
@ExtendWith(SpringExtension.class)
@DirtiesContext
public class SimpleMongoWriterTest {
  @Test
  void createCollectionAndCount(@Autowired final MongoTemplate mongoTemplate) {
    mongoTemplate.getDb().createCollection("deleteMe");
    long count = mongoTemplate.getDb().getCollection("deleteMe").countDocuments(Document.parse("{}"));
    Assertions.assertThat(mongoTemplate.getDb()).isNotNull();
    Assertions.assertThat(count).isEqualTo(0L);
  }

  @Test
  void createCollectionAndWrite(@Autowired final MongoTemplate mongoTemplate) {
    mongoTemplate.getDb().createCollection("myCollection");
    Map<String, String> myMap = new HashMap<String, String>();
    mongoTemplate.insert(myMap, "myCollection");
    long count = mongoTemplate.getDb().getCollection("myCollection").countDocuments(Document.parse("{}"));
    Assertions.assertThat(count).isEqualTo(1L);
  }
}
