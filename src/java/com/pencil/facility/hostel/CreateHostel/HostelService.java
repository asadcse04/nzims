/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.hostel.CreateHostel;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface HostelService {
    
    public boolean addHostel(Hostel hostel);
    
    public boolean updateHostel(Hostel hostel);
    
    public List<Hostel> getAllHostel();
    
}
