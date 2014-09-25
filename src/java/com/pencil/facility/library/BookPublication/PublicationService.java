/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookPublication;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface PublicationService {

    public boolean addPublication(Publication publication);
    
    public boolean updatePublication(Publication publication);

    public List<Publication> getAllPublication();

}
