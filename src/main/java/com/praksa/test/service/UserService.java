package com.praksa.test.service;

import com.praksa.test.model.SenzorRecord;
import com.praksa.test.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    List<User> getUsers();

    void addUser(String name);

    void updateTimeStampToUser(int id);

    void deleteRecord(int id);

    void addWeather(Map<String, Object> weatherData);

    int addSensorRecord(SenzorRecord request);

    SenzorRecord getLastSensorRecord();
}
