package com.gade.gps.strava.config;

import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) {
    	PropertiesPropertySource result = new PropertiesPropertySource("empty", new Properties());
		String fileName = Optional.of(encodedResource)
				.map(EncodedResource::getResource)
				.map(Resource::getFilename)
				.orElse(null);
		if ( fileName != null ) {
	    	try {
	    		
		        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
		        factory.setResources(encodedResource.getResource());
		        Properties factoryObj = factory.getObject();
		        if ( factoryObj != null ) {
		    		log.debug("Loading YAML configuration from {}", encodedResource.getResource().getFilename());
			        result = new PropertiesPropertySource(fileName, factoryObj);
		        } else {
		    		log.warn("Unable to crete factory object. Name {}, Filename {}", 
		    				name, fileName);		        	
		        }
	    	} catch ( Exception ioe ) {
	    		log.warn("Unable to find resource file. Name {}, Filename {} - Exception {}", 
	    				name, fileName, ioe.getMessage());
	    	}
		} else {
    		log.warn("Unable to determine resource file for {}", name);
		}
		return result;
    }
}