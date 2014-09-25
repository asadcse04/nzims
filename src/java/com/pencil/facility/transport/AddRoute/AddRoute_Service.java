/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.AddRoute;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface AddRoute_Service {
    
    public boolean createAddRoute(AddRoute route);
    
    public boolean updateRoute(AddRoute upRoute);
    
    List<AddRoute> addRouteList();
}
