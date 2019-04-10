/*
 *  Terrence Takunda Munyunguma [https://github.com/TerrenceTakunda]
 *  Copyright (C) 2019 ttmunyunguma@gmail.com
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.cuius.web.cuius_web.ai;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.nd4j.shade.jackson.databind.ObjectMapper;

/**
 * Helper class with a static method that returns the label description
 * 
 * @author terrence
 */
public class ImageNetLabels {
    
    static FacesContext context = FacesContext.getCurrentInstance();
    static ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
    static String path = servletContext.getRealPath("/");
    private final static File jsonUrl = new File(path + "/resources/imagenet_class_index.json");
    private static ArrayList<String> predictionLabels = null;
    
    public static ArrayList<String> getLabels() {
        if (predictionLabels == null) {
            HashMap<String, ArrayList<String>> jsonMap;
            try {
                jsonMap = new ObjectMapper().readValue(jsonUrl, HashMap.class);
                predictionLabels = new ArrayList<>(jsonMap.size());
                for (int i = 0; i < jsonMap.size(); i++) {
                    predictionLabels.add(jsonMap.get(String.valueOf(i)).get(1));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return predictionLabels;
    }
    
    
    //Returns the description of the nth class in the 1000 classes of ImageNet
     
    public static String getLabel(int n) {
        if (predictionLabels == null) {
            getLabels();
        }
        return predictionLabels.get(n);
    }
    
}
