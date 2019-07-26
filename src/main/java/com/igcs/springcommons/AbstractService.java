package com.igcs.springcommons;


import com.igcs.springcommons.utils.ResourceUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService<ResourceType> implements CommonService<ResourceType> {

    protected JpaRepository<ResourceType, Long> repository;

    public AbstractService() {}

    protected AbstractService( JpaRepository repository ) {
        this.repository = repository;
    }

    @Override
    public ResourceType save( ResourceType resource ) {
        return repository.save( resource );
    }

    @Override
    public List<ResourceType> getAll() {
        return repository.findAll();
    }

    @Override
    public ResourceType getResource( long id ) {
        return repository.getOne( id );
    }

    @Override
    public ResourceType updateResource( long id, ResourceType resource ) {
        ResourceUtils.updateResource( repository.findById( id ).get(), resource );
        return repository.save( resource );
    }

    @Override
    public boolean deleteResource( long id ) {
        if ( repository.existsById( id ) ) {
            repository.deleteById( id );
            return true;
        }
        return false;
    }
}
