/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddSeat;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public class SeatServiceImpl implements SeatService {

    @Override
    public boolean addSeat(Seat seat) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into hostel_addseat values (null, ?, ?, ?, (select Room_ID from hostel_addroom where Room_Name=? ))");

            prst.setString(1, seat.getSeatName());

            prst.setString(2, seat.getSeatLocation());

            prst.setString(3, seat.getSeatNote());

            prst.setString(4, seat.getRoomName());

            prst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        }

        return false;
    }

    @Override
    public boolean updateSeat(Seat seat) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update hostel_addseat set Seat_Name=?, Seat_Location=?, Note=?, Room_ID =(Select Room_ID from hostel_addroom where Room_Name=?)  where Seat_ID=?");

            prst.setString(1, seat.getSeatName());

            prst.setString(2, seat.getSeatLocation());

            prst.setString(3, seat.getSeatNote());

            prst.setString(4, seat.getRoomName());

            prst.setInt(5, seat.getSeatId());

            prst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        }

        return false;

    }

    @Override
    public List<Seat> getAllSeat() {

        List<Seat> seatAllList = new ArrayList<Seat>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select has.Seat_ID, has.Seat_Name, has.Seat_Location, has.Note, has.Room_ID, ar.Room_Name from hostel_addseat has, hostel_addroom ar where has.Room_ID=ar.Room_ID");

            rs = prst.executeQuery();

            while (rs.next()) {

                seatAllList.add(new Seat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));

            }
            return seatAllList;

        } catch (SQLException ex) {

            System.out.println(ex);
        } finally {
            try {

                if (rs != null) {

                    rs.close();

                }

                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        }

        return seatAllList;

    }

}
