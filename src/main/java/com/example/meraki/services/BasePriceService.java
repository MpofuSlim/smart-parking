package com.example.meraki.services;


import com.example.meraki.common.createrequests.CreateAuthenticationRequestDTO;
import com.example.meraki.common.createrequests.CreateBasePriceRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBasePriceRequestDTO;
import com.example.meraki.entities.Authenticate;
import com.example.meraki.entities.BasePrice;
import com.example.meraki.repositories.BasePriceRepository;
import com.example.meraki.services.response.CreateAuthenticateResponse;
import com.example.meraki.services.response.CreateBasePriceResponse;
import com.example.meraki.services.response.UpdateBasePriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BasePriceService {
    @Autowired
    private BasePriceRepository basePriceRepository;

    public BasePriceService(BasePriceRepository basePriceRepository) {
        this.basePriceRepository = basePriceRepository;
    }

    public BasePrice getBasePrice(Long id) {
        return basePriceRepository.getReferenceById(id);
    }


    public List<BasePrice> getAllBasePrice() {
        return basePriceRepository.findAll();
    }


    @Transactional
    public CreateBasePriceResponse CreateBasePrice(CreateBasePriceRequestDTO createBasePriceRequestDTO) {
        BasePrice basePrice1 = basePriceRepository.getReferenceById(createBasePriceRequestDTO.getId());

        BasePrice basePrice = new BasePrice(
                basePrice1.getPrice());

        basePriceRepository.save(basePrice);

        return new CreateBasePriceResponse(
                basePrice.getId(),
                basePrice1.getPrice()
        );
    }

    public UpdateBasePriceResponse updateBasePrice(UpdateBasePriceRequestDTO updateBasePriceRequestDTO) {

        BasePrice basePrice = basePriceRepository.getReferenceById(updateBasePriceRequestDTO.getId());
        basePrice.setPrice(updateBasePriceRequestDTO.getPrice());
        ;

        basePriceRepository.save(basePrice);

        UpdateBasePriceResponse updateBasePriceResponse = new UpdateBasePriceResponse(
                basePrice.getPrice()

        );

        return updateBasePriceResponse;
    }

 /*   @Service
    public static class MobileMoneyService {
        private CreateAuthenticationRequestDTO createAuthenticationRequestDTO;


        public CreateAuthenticateResponse createAuthentication(CreateAuthenticationRequestDTO createAuthenticationRequestDTO) {
            Authenticate authenticate = new Authenticate(

                    "InnovationEcocash",
                    "InnoEco@15022023#"

            );

            return new CreateAuthenticateResponse(
                    authenticate


            );
        }
    }*/
}
