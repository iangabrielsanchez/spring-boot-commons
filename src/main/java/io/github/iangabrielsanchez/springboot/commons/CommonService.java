package io.github.iangabrielsanchez.springboot.commons;

import java.util.List;

public interface CommonService<ResourceType> {

    ResourceType save( ResourceType resource );

    List<ResourceType> getAll();

    ResourceType getResource( long id );

    ResourceType updateResource( long id, ResourceType resource );

    boolean deleteResource( long id );

}
