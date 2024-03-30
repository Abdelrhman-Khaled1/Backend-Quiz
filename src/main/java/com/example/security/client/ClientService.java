package com.example.security.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    public void save(ClientDtoRequest clientDtoRequest) {
        clientRepository.save(
                Client.builder()
                        .email(clientDtoRequest.getEmail())
                        .name(clientDtoRequest.getName())
                        .lastName(clientDtoRequest.getLastName())
                        .address(clientDtoRequest.getAddress())
                        .mobile(clientDtoRequest.getMobile())
                        .build()
        );
    }


    public void update(Long id, ClientDtoRequest clientDtoRequest) {
        Client client = clientRepository.findById(id).get();
        client.setName(client.getName());
        client.setEmail(clientDtoRequest.getEmail());
        client.setLastName(clientDtoRequest.getLastName());
        client.setAddress(clientDtoRequest.getAddress());
        client.setMobile(clientDtoRequest.getMobile());
        clientRepository.save(client);
    }


    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
