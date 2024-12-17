package com.praksa.test.controller;

import com.praksa.test.model.User;
import com.praksa.test.service.UserService;
import com.praksa.test.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class TestController {

    private final UserService service;
    private final WeatherService weatherService;

    @Autowired
    public TestController(UserService service, WeatherService weatherService) {
        this.service = service;
        this.weatherService = weatherService;
    }

//    @GetMapping
//    public ResponseEntity<String> getName() {
//        String name = "praksa" ;
//        return ResponseEntity.ok(name);
//    }

    @PostMapping("/post")
    public ResponseEntity<String> postName(@RequestParam String name) {
        System.out.println(name);

        service.addUser(name) ;
        return ResponseEntity.ok("My name is" + name);
    }

    @GetMapping
    public ResponseEntity<List<User>> getListOfUsers() {
        List<User> list = service.getUsers();
        return ResponseEntity.ok(list);

    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<Void> updateTimeStampToUser(@PathVariable int id) {
        service.updateTimeStampToUser(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable int id) {
        service.deleteRecord(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/weather/{city}")
    public ResponseEntity<Map<String, Object>> getWeather(@PathVariable String city) {
        Map<String, Object> weatherData = weatherService.getWeatherForCity(city);
        service.addWeather(weatherData);
        return ResponseEntity.ok(weatherData);
    }

}
