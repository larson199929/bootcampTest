package com.nttdata.product;

import com.nttdata.product.api.ApiApiDelegate;
import com.nttdata.product.model.ErrorResponse;
import com.nttdata.product.model.ProductoRequest;
import com.nttdata.product.model.ProductoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    private final List<ProductoResponse> productosRegistrados = new ArrayList<>();

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public ResponseEntity<ProductoResponse> registrarProducto(ProductoRequest productoRequest) {

        if (productoRequest == null
                || productoRequest.getNombre() == null || productoRequest.getNombre().isBlank()
                || productoRequest.getPrecio() == null || productoRequest.getPrecio() <= 0
                || productoRequest.getStock() == null || productoRequest.getStock() < 0) {

            ErrorResponse error = new ErrorResponse()
                    .codigo("400")
                    .mensaje("datos invalidos")
                    .detalle("nombre es obligatorio, precio debe ser mayor a 0 y stock no puede ser negativo");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        }

        ProductoResponse producto = new ProductoResponse();
        producto.setId(UUID.randomUUID().toString());
        producto.setNombre(productoRequest.getNombre());
        producto.setDescripcion(productoRequest.getDescripcion());
        producto.setPrecio(productoRequest.getPrecio());
        producto.setStock(productoRequest.getStock());
        producto.setCategoria(productoRequest.getCategoria());
        producto.setFechaCreacion(OffsetDateTime.now());

        productosRegistrados.add(producto);
        return ResponseEntity.ok(producto);
    }

}
