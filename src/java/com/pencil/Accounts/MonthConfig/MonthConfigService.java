/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.MonthConfig;

import java.util.List;

/**
 *
 * @author Mamun
 */
public interface MonthConfigService {
    
    public boolean addMonth(MonthConfig monthConfig);
    
    public boolean updateMonth(MonthConfig monthConfig);
    
    public List<MonthConfig> getMonthConfigList();
}
