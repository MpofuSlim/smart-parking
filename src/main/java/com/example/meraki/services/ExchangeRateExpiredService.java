package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateExchangeRateExpiredRequestDTO;
import com.example.meraki.common.updaterequests.UpdateExchangeRateExpiredRequestDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.ExchangeRateExpired;
import com.example.meraki.repositories.AdminPortalUsersRepository;
import com.example.meraki.repositories.ExchangeRateExpiredRepository;
import com.example.meraki.services.response.CreateExchangeRateExpiredResponse;
import com.example.meraki.services.response.UpdateExchangeRateExpiredResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExchangeRateExpiredService {
    @Autowired
    private ExchangeRateExpiredRepository exchangeRateExpiredRepository;

    private final AdminPortalUsersRepository adminPortalUsersRepository;

    public ExchangeRateExpiredService( ExchangeRateExpiredRepository exchangeRateExpiredRepository,
                                       AdminPortalUsersRepository adminPortalUsersRepository) {
        this.exchangeRateExpiredRepository = exchangeRateExpiredRepository;
        this.adminPortalUsersRepository = adminPortalUsersRepository;
    }

    public ExchangeRateExpired getExchangeRateExpired(Long id) {
        return exchangeRateExpiredRepository.getReferenceById(id);
    }

    public List<ExchangeRateExpired> getAllExchangeRatesExpired() {return exchangeRateExpiredRepository.findAll();}

    public CreateExchangeRateExpiredResponse createExchangeRateExpired(CreateExchangeRateExpiredRequestDTO createExchangeRateExpiredRequestDTO) throws IOException {
        AdminPortalUsers user1 = adminPortalUsersRepository.getReferenceById(createExchangeRateExpiredRequestDTO.getUserID());
        ExchangeRateExpired exchangeRateExpired = new ExchangeRateExpired(
                user1,
                createExchangeRateExpiredRequestDTO.getExchangeRateExpired().getRate(),
                createExchangeRateExpiredRequestDTO.getExchangeRateExpired().getDate_created()
        );

        exchangeRateExpiredRepository.save(exchangeRateExpired);

        return new CreateExchangeRateExpiredResponse(
                exchangeRateExpired,
                user1
        );
    }

    public UpdateExchangeRateExpiredResponse updateExchangeRateExpired(UpdateExchangeRateExpiredRequestDTO updateExchangeRateExpiredRequestDTO) {

        ExchangeRateExpired exchangeRateExpired = exchangeRateExpiredRepository.getReferenceById(updateExchangeRateExpiredRequestDTO.getId());
        exchangeRateExpired.setRate(updateExchangeRateExpiredRequestDTO.getRate());

        exchangeRateExpiredRepository.save(exchangeRateExpired);

        UpdateExchangeRateExpiredResponse updateExchangeRateExpiredResponse = new UpdateExchangeRateExpiredResponse(
                exchangeRateExpired.getRate()

        );

        return  updateExchangeRateExpiredResponse;
    }
}
