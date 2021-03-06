/*
 * KBAccess - Collaborative database of accessibility examples
 * Copyright (C) 2012-2016  Open-S Company
 *
 * This file is part of KBAccess.
 *
 * KBAccess is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.kbaccess.entity.statistics;

/**
 *
 * @author blebail
 */
public interface AccountStatistics {
    
    /**
     * 
     * @return The id of the account in database
     */
    Long getId();
    
    /**
     * 
     * @param id The id of the account in database
     */
    void setId(Long id);
    
    /**
     * 
     * @return The displayed name of the account in database
     */
    String getDisplayedName();
    
    /**
     * 
     * @param displayedName The displayed name of the account in database
     */
    void setDisplayedName(String displayedName);
    
    /**
     * 
     * @return The number of testcases relating to this account
     */
    Long getTestcaseCount();
    
    /**
     * 
     * @param testcaseCount The number of testcases relating to this account
     */
    void setTestcaseCount(Long testcaseCount);
    
}
