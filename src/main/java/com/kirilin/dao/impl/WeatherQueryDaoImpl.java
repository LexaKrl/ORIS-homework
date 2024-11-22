package com.kirilin.dao.impl;

import com.kirilin.dao.WeatherQueryDao;
import com.kirilin.util.DatabaseConnectionUtil;

public class WeatherQueryDaoImpl implements WeatherQueryDao {
    //language=sql
    private static final String SQL_SAVE = "insert into weather_query (city, username) VALUES (?, ?)";

    @Override
    public void save() {

    }
}
