/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.AddDriver;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface Driver_Service {
    
    public boolean createDriver(Driver add);
    
    public List<Driver> driverList();

    public boolean updateDriver(Driver driver);
    
}
