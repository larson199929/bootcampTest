package com.nttdata.product.api;

import com.nttdata.product.model.ProductoResponse;
import com.nttdata.product.service.CatalogoProductos;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListadoProductosDelegate implements ApiApiDelegate {

    private final CatalogoProductos catalogo;

    public ListadoProductosDelegate(CatalogoProductos catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public ResponseEntity<List<ProductoResponse>> listarProductos() {
        List<ProductoResponse> productos = catalogo.listar();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }
}
