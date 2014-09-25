/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.TransportType;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface TransportType_Service {
    
    public boolean createTransportType(TransportType transportType);
    
    public boolean updateTransportType(TransportType upTransport);
    
    public List<TransportType> transportList();
}
