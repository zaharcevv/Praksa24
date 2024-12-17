package com.praksa.test.service;

import com.praksa.test.model.User;
import com.praksa.test.repository.DbAccessor;
import com.praksa.test.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final DbAccessor dbAccessor;


    @Autowired
    public UserServiceImpl(DbAccessor dbAccessor) {
        this.dbAccessor = dbAccessor;
    }

    @Override
    public List<User> getUsers() {
        return dbAccessor.getName();
    }

    @Override
    public void addUser(String name) {
        String timestamp = DateUtil.getCurrentDateTime();
        dbAccessor.addUser(name, timestamp);
    }

    @Override
    public void updateTimeStampToUser(int id) {
        String timestamp = DateUtil.getCurrentDateTime();
        dbAccessor.updateTimeStampToUser(id, timestamp);
    }

    @Override
    public void deleteRecord(int id) {
        dbAccessor.deleteRecord(id);
    }

    @Override
    public void addWeather(Map<String, Object> weatherData) {
        String timestamp = DateUtil.getCurrentDateTime();

        // Extract temp and humidity from weatherData
        Double temp = (Double) weatherData.get("temp");
        Integer humidity = (Integer) weatherData.get("humidity");

        // Pass the extracted values along with the timestamp to dbAccessor
        dbAccessor.addWeather(temp.toString(), humidity.toString(), timestamp);
    }

}
