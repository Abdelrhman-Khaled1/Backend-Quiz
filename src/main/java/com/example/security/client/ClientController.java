package com.example.security.client;

import com.example.security.product.Product;
import com.example.security.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClientDtoRequest clientDtoRequest){
        clientService.save(clientDtoRequest);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id , @RequestBody ClientDtoRequest clientDtoRequest){
        clientService.update(id ,clientDtoRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAllClients(){
        return ResponseEntity.ok(clientService.findAll());
    }


}
