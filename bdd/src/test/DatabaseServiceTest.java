package test;

import static org.junit.Assert.*;

import com.example.model.City;
import com.example.service.DatabaseConnection;
import com.example.service.DatabaseService;
import org.junit.After;
import org.junit.Before;


import java.sql.Connection;

import static org.junit.Assert.*;


public class DatabaseServiceTest {

    DatabaseConnection ct;
    Connection con;

    @Before
    public void init()
    {
        ct =  new DatabaseConnection("sa","","org.h2.Driver","jdbc:h2:mem:test");
        con = ct.connect();
        ct.createDb(con);
    }

    @After
    public void fin()
    {
        ct.disconnect(con);
    }

    @org.junit.Test
    public void addCityTest()
    {

        City cityA =  new City(1,"Paris",100,"hello");
        assertEquals(1, DatabaseService.addCity(con,cityA));
    }

    @org.junit.Test
    public void getCitiesTest()
    {
        City a =  new City(1,"Paris",100,"hello");
        DatabaseService.addCity(con,a);
        City b=  new City(2,"Alger",100,"hy");
        DatabaseService.addCity(con,b);
        City [] cities = {a,b};
     assertArrayEquals(cities,DatabaseService.getCities(con).toArray());
    }
}