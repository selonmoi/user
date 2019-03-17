package com.operantic.ote.user.helper;

import com.operantic.ote.user.model.ModelEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class ControllerHelper {

    public static ResponseEntity<Void> getSaveEntity(ModelEntity entity) {
        if (entity == null) return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
