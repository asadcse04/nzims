/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Login.PasswordChange;

import java.util.List;

/**
 *
 * @author SHOHUG.SQ
 */
public interface PasswordChangeService {

    public boolean updatePassword(PasswordChange passwordChange);

    public boolean currentPassword(PasswordChange passwordChange);

    public List<String> checkPassword(PasswordChange passwordChange);

}
