/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.AddTransport;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface AddTransport_Service {
    
    public boolean createTransport(AddTransport addTransport);
    
    public boolean updateTransport(AddTransport upTransport);
    
    public List<AddTransport> transportList();
    
    public List<String> transportTypeNameList();
    
}
