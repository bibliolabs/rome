/*
 * Copyright 2005 Robert Cooper, Temple of the Screaming Penguin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.rometools.modules.itunes;

import java.net.URL;
import java.util.List;

import com.rometools.modules.itunes.types.Category;

/**
 * This class contains information for iTunes podcast feeds that exist at the Channel level.
 *
 * @author <a href="mailto:cooper@screaming-penguin.com">Robert "kebernet" Cooper</a>
 * @version $Revision: 1.2 $
 */
public interface FeedInformation extends ITunes {

    /**
     * The parent categories for this feed
     *
     * @return The parent categories for this feed
     */
    public List<Category> getCategories();

    /**
     * The parent categories for this feed
     *
     * @param categories The parent categories for this feed
     */
    public void setCategories(List<Category> categories);

    public boolean getComplete();

    public void setComplete(boolean complete);

    public String getNewFeedUrl();

    public void setNewFeedUrl(String newFeedUrl);

    /**
     * Sets the owner email address for the feed.
     *
     * @param ownerEmailAddress Sets the owner email address for the feed.
     */
    public void setOwnerEmailAddress(String ownerEmailAddress);

    /**
     * Returns the owner email address for the feed.
     *
     * @return Returns the owner email address for the feed.
     */
    public String getOwnerEmailAddress();

    /**
     * Sets the owner name for the feed
     *
     * @param ownerName Sets the owner name for the feed
     */
    public void setOwnerName(String ownerName);

    /**
     * Returns the owner name for the feed
     *
     * @return Returns the owner name for the feed
     */
    public String getOwnerName();
}
