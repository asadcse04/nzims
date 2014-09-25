/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddSeat;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface SeatService {

    public boolean addSeat(Seat seat);

    public boolean updateSeat(Seat seat);

    public List<Seat> getAllSeat();

}
