package com.jean.accountmanager.manager.application.mapper;

import com.jean.accountmanager.manager.application.request.TransactionRequest;
import com.jean.accountmanager.manager.application.response.TransactionResponse;
import com.jean.accountmanager.manager.domain.model.Transaction;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionMapper {

    private final ModelMapper modelMapper;

    public TransactionResponse toResponse(Transaction domain) {
        return modelMapper.map(domain, TransactionResponse.class);
    }

    public Transaction toDomain(TransactionRequest request) {
        return modelMapper.map(request, Transaction.class);
    }
}
