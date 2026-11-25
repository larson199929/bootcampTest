package com.nttdata.product;

import com.nttdata.product.api.ApiApiDelegate;
import com.nttdata.product.model.ProductoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiApiDelegateByIdImpl implements ApiApiDelegate {

    @Override
    public ResponseEntity<ProductoResponse> obtenerProductoPorId(String id) {

        List<ProductoResponse> productos = new ArrayList<>();

        ProductoResponse p1 = new ProductoResponse();
        p1.setId("1");
        p1.setNombre("Laptop");

        ProductoResponse p2 = new ProductoResponse();
        p2.setId("2");
        p2.setNombre("Mouse");

        productos.add(p1);
        productos.add(p2);

        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
