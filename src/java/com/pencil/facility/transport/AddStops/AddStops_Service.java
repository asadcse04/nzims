/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.AddStops;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface AddStops_Service {
    
    public boolean createStops(AddStops stops);
    
    public boolean updateStops(AddStops upStops);
    
    List<AddStops> addStopsList();
    
    List<String> routeNameList();
}
