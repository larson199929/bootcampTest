package com.nttdata.product.service;

import com.nttdata.product.model.ProductoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoProductos {

    public List<ProductoResponse> listar() {
        return List.of(
                new ProductoResponse()
                        .id("12345")
                        .nombre("Laptop Lenovo ThinkPad")
                        .descripcion("Laptop empresarial con 16GB RAM")
                        .precio(1200.50)
                        .categoria("Tecnología")
                        .stock(10)
                        .fechaCreacion("18/02/2026 10:30:00"),
                new ProductoResponse()
                        .id("12346")
                        .nombre("Monitor LG de 24 pulgadas")
                        .descripcion("Monitor Full HD con entrada HDMI")
                        .precio(450.00)
                        .categoria("Tecnología")
                        .stock(15)
                        .fechaCreacion("19/02/2026 14:15:00"),
                new ProductoResponse()
                        .id("12347")
                        .nombre("Teclado Logitech K120")
                        .descripcion("Teclado USB de tamaño completo")
                        .precio(65.90)
                        .categoria("Accesorios")
                        .stock(25)
                        .fechaCreacion("20/02/2026 09:45:30"));
    }
}
