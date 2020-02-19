package com.example.test;

import com.example.dao.IReservationDao;
import com.example.dao.IRoomDao;
import com.example.model.Guest;
import com.example.model.Reservation;
import com.example.model.Room;
import com.example.service.BookService;
import org.junit.Before;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class BookServiceTest {
    IRoomDao iRoomDao;
    IReservationDao iReservationDao;
    BookService s;
    @Before
    public void setUp() throws Exception {
      iRoomDao= Mockito.mock (IRoomDao.class);
      iReservationDao = Mockito.mock(IReservationDao.class);
      s= new BookService(iRoomDao,iReservationDao);
    }

    @org.junit.Test
    public void bookRoomTest() throws ParseException
    {
       SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
       Date date_in = sdf.parse("22-01-2019");
       Date date_out = sdf.parse("29-01-2019");
       Room rom = new Room (1,"a",3);
       Guest gues= new Guest("imene","rekkas");
       Reservation reserv=new Reservation(date_in,date_out,rom,gues);
        Mockito.when(iRoomDao.isAvailable(rom,date_in,date_out)).thenReturn(true);
        Mockito.when(iReservationDao.createReservation(reserv)).thenReturn(true);
        assertTrue(s.bookRoom(rom,date_in,date_out,gues));

    }

    @org.junit.Test

    public void cancelReservationTest() throws ParseException
    {
        SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
        Date date_in = sdf.parse("22-01-2019");
        Date date_out = sdf.parse("29-01-2019");
        Room rom = new Room (1,"a",3);
        Guest gues= new Guest("imene","rekkas");
        Reservation reserv=new Reservation(date_in,date_out,rom,gues);
        Mockito.when(iReservationDao.findReservation(1)).thenReturn(reserv);
        Mockito.when(iReservationDao.cancelReservation(reserv)).thenReturn(true);
        assertTrue(s.cancelReservation(rom.getId()));
    }

}