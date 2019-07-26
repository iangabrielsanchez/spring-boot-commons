package com.igcs.springcommons.utils;

import java.lang.reflect.Field;

public class ResourceUtils {

    public static <E> E updateResource( E oldResource, E newResource ) {
        //Get declared fields
        for ( Field field : newResource.getClass().getDeclaredFields() ) {
            try {
                field.setAccessible( true );
                Object fieldValue = field.get( newResource );
                //If null, set it from the old value
                if ( fieldValue == null ) {
                    Object oldValue = field.get( oldResource );
                    field.set( newResource, oldValue );
                }
            } catch ( IllegalAccessException ex ) {
                //logger.fatal( "Failed to update user info.", ex );
            }
        }
        return newResource;
    }
}
