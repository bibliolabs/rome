/**
 *
 *  Copyright (C) The ROME Team  2011
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

 
package org.rometools.certiorem.hub.data.ram;

import org.rometools.certiorem.hub.data.AbstractDAOTest;
import org.rometools.certiorem.hub.data.HubDAO;

/**
 *
 * @author robert.cooper
 */
public class InMemoryDAOTest extends AbstractDAOTest{
    private InMemoryHubDAO dao = new InMemoryHubDAO();

    public InMemoryDAOTest() {
    }

    @Override
    protected HubDAO get() {
        return dao;
    }


    


}