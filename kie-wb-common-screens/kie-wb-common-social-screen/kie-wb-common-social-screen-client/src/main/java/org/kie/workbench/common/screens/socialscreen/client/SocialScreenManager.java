/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.screens.socialscreen.client;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.kie.workbench.common.screens.socialscreen.place.SocialScreenPlace;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.workbench.events.ResourceOpenedEvent;

@ApplicationScoped
public class SocialScreenManager {

    private PlaceManager placeManager;
    private Path currentPath;

    public SocialScreenManager() {
    }

    @Inject
    public SocialScreenManager(PlaceManager placeManager) {
        this.placeManager = placeManager;
    }

    public void onResourceOpenedEvent(@Observes ResourceOpenedEvent event) {
        currentPath = event.getPath();
//        placeManager.goTo(new SocialScreenPlace());
        placeManager.goTo("MarkdownLiveEditor");

    }

    public Path getCurrentPath() {
        return currentPath;
    }
}