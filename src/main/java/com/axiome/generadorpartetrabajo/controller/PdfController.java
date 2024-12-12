package com.axiome.generadorpartetrabajo.controller;

import com.axiome.generadorpartetrabajo.entity.Cliente;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generatePDF(@RequestBody Cliente cliente) {
        ByteArrayOutputStream pdfBytes = generatePdfFromCliente(cliente);

        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf")
                .header("Content-Disposition", "attachment; filename=cliente.pdf")
                .body(pdfBytes.toByteArray());
    }

    private ByteArrayOutputStream generatePdfFromCliente(Cliente cliente) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Aquí implementas la lógica para generar el PDF con los datos del cliente
        return outputStream;
    }
}
