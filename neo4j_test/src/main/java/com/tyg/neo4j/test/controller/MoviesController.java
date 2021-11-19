//package com.tyg.neo4j.test.controller;
//
//import org.neo4j.driver.Driver;
//import org.neo4j.driver.Session;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/movie")
//public class MoviesController {
//
//	private final Driver driver;
//
//	public MoviesController(Driver driver) {
//		this.driver = driver;
//	}
//
//	@GetMapping(path = "/getMovieTitles", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<String> getMovieTitles() {
//
//		try (Session session = driver.session()) {
//			return session.run("MATCH (m:ZzSchool) RETURN m ORDER BY m.school_name ASC")
//				.list(r -> r.get("m").asNode().get("school_id").asString());
//		}
//	}
//}
