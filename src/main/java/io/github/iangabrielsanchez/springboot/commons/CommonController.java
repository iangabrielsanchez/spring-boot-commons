package io.github.iangabrielsanchez.springboot.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CommonController<ItemType> {


    default ResponseEntity<List<ItemType>> handle( List<ItemType> list, HttpStatus status ) {
        return new ResponseEntity<>( list, status );
    }

    default ResponseEntity<ItemType> handle( ItemType body, HttpStatus status ) {
        return new ResponseEntity<>( body, status );
    }

    default ResponseEntity<String> handle( String message, HttpStatus status ) {
        return new ResponseEntity<>( message, status );
    }

    ResponseEntity<List<ItemType>> getAll();

    ResponseEntity<ItemType> getOne( @PathVariable( "id" ) Long id );

    ResponseEntity<ItemType> add( @RequestBody ItemType item );

    ResponseEntity<ItemType> update( @PathVariable( "id" ) Long id, @RequestBody ItemType item );

    ResponseEntity<?> delete( @PathVariable( "id" ) Long id );
}
