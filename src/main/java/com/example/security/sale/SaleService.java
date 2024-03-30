package com.example.security.sale;

import com.example.security.auth.AuthenticationService;
import com.example.security.client.ClientService;
import com.example.security.sale.orderline.ProductOrderLineDtoRequest;
import com.example.security.user.User;
import com.example.security.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final UserService userService;
    private final ClientService clientService;
    private final AuthenticationService authenticationService;

    public void save(SaleOperationDtoRequest saleOperationDtoRequest) {
        List<ProductOrderLineDtoRequest> productsList = saleOperationDtoRequest.getProductsList();

        //we need to save every element in the product


        UserDetails loggedInUser = authenticationService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        User user = userService.findByEmail(loggedInUser.getUsername()).get();

        SaleOperation.builder()
                .seller(user)
                .client(clientService.findById(saleOperationDtoRequest.getClient_id()))
                .build();
    }
}
