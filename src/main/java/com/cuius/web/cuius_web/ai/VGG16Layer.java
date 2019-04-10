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

import com.cuius.web.cuius_web.handler.DisplayProductMB;
import com.cuius.web.cuius_web.handler.SearchProduct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.zoo.ZooModel;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.VGG16ImagePreProcessor;
import org.deeplearning4j.zoo.model.VGG16;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.nd4j.linalg.factory.Nd4j;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author terrence
 */
@Named(value = "vGG16Layer")
@SessionScoped
public class VGG16Layer implements Serializable {
    
    // ======================================
    // =          Injection Points          =
    // ======================================
    
    @Inject
    SearchProduct search;
    
    // ======================================
    // =             Attributes             =
    // ======================================
    
    UploadedFile file;
    private static Logger log = LoggerFactory.getLogger(VGG16Layer.class);
    private int height = 224;
    private int width = 224;
    private int channels = 3;

    /**
     * Creates a new instance of VGG16Layer
     */
    public VGG16Layer() {
    }
    
    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    
    // ======================================
    // =          Business methods          =
    // ======================================
        
    public void classifyImage(File file) {
        
        if (file != null) {
            
            try {
                //load the model --> import org.deeplearning4j.transferlearning.vgg16 and print summary
                log.info("\n\nLoading org.deeplearning4j.transferlearning.vgg16...\n\n");
                ZooModel zooModel = VGG16.builder().build();
                ComputationGraph computationGraph = (ComputationGraph) zooModel.initPretrained();
//                log.info(computationGraph.summary());

                //load the image to classify
                NativeImageLoader loader = new NativeImageLoader(height, width, channels);
                INDArray image = loader.asMatrix(file);
                DataNormalization scaler = new VGG16ImagePreProcessor();
                scaler.transform(image);

                //Inference returns array of INDArray, index[0] has the predictions
                INDArray[] output = computationGraph.output(false, image);
                INDArray predictions = output[0];

                log.info("*********PREDICTIONS DECODED********");
                ArrayList<String> labels = ImageNetLabels.getLabels();
                String predictionDescription = "";
                int[] top = new int[1];
                float[] topProb = new float[1];

                //brute force collect top prediction
                int i = 0;
                for (int batch = 0; batch < predictions.size(0); batch++) {

                    predictionDescription += "Predictions for batch ";
                    if (predictions.size(0) > 1) {
                        predictionDescription += String.valueOf(batch);
                    }
                    predictionDescription += " :";
                    INDArray currentBatch = predictions.getRow(batch).dup();

                    while (i < 1) {
                        top[i] = Nd4j.argMax(currentBatch, 1).getInt(0, 0);
                        topProb[i] = currentBatch.getFloat(batch, top[i]);
                        currentBatch.putScalar(0, top[i], 0);
                        predictionDescription += "\n\t" + String.format("%3f", topProb[i] * 100) + "%, " + labels.get(top[i]);
                        
                        //pass the labeled string to search algorithm
                        search.setKeyword(labels.get(top[i]));
                        i++;
                    }
                }

                log.info(predictionDescription);

            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(VGG16Layer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void uploadImage(FileUploadEvent event){
        
        this.file = event.getFile();
        
        if(file != null){
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
                String dbPath = servletContext.getRealPath("/");
                InputStream inputStream = file.getInputstream();
                String path = dbPath + "/resources/images/classify/" + file.getFileName();
                File destFile = new File(path);
                if(!destFile.exists())
                    FileUtils.copyInputStreamToFile(inputStream, destFile);
                log.info("**********Destination file**" + destFile.toString());
                classifyImage(destFile);
                FacesMessage msg = new FacesMessage("Search Succesful", "Now running classification on file: " + event.getFile().getFileName());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(VGG16Layer.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
            search.searchedResults();
        }
    }
}


