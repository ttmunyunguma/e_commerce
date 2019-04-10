/*
 * Terrence Takunda Munyunguma [https://github.com/TerrenceTakunda]
 * Copyright (C) 2019 ttmunyunguma@gmail.com
 * 
 * This program is free software: you can redistribute it and/or modify
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
 */
package com.cuius.web.cuius_web.gis;

import com.gisfaces.event.MapGeoLocationEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author terrence
 */
@Named(value = "geoLocationBean")
@SessionScoped
public class GeoLocationBean implements Serializable {

    private static final long serialVersionUID = -8866985012091642915L;

    private boolean watch;
    private boolean accuracy;
    private int timeout;
    private int maximumAge;
    private MapGeoLocationEvent event;

    /**
     * Creates a new instance of GeoLocationBean
     */
    public GeoLocationBean() {
        super();
        reset();
    }
    
    public void reset() {
        this.watch = true;
        this.accuracy = true;
        this.timeout = 60000;
        this.maximumAge = 0;
        this.event = null;
    }
    
    public void doGeoLocationListener(AjaxBehaviorEvent event) {
        
        this.event = (MapGeoLocationEvent) event;
    }
    
    //Setters And Getters
    
    public boolean isWatch() {
        return watch;
    }

    public void setWatch(boolean watch) {
        this.watch = watch;
    }

    public boolean isAccuracy() {
        return accuracy;
    }

    public void setAccuracy(boolean accuracy) {
        this.accuracy = accuracy;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    public MapGeoLocationEvent getEvent() {
        return event;
    }

    public void setEvent(MapGeoLocationEvent event) {
        this.event = event;
    }
    
}
