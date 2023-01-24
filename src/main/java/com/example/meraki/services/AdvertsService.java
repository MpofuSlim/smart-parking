package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateAdvertsRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdvertsRequestDTO;
import com.example.meraki.entities.Adverts;
import com.example.meraki.repositories.AdvertsRepository;
import com.example.meraki.services.response.CreateAdvertsResponse;
import com.example.meraki.services.response.UpdateAdvertsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdvertsService {
    @Autowired
    public AdvertsRepository advertsRepository;


    public AdvertsService(AdvertsRepository advertsRepository) {
        this.advertsRepository = advertsRepository;
    }


    public List<Adverts> getActiveById(Long id) {
        return advertsRepository.findByid(id);
    }


    public List<Adverts> getAdvertsByActive(Boolean active) {
        return advertsRepository.findByActive(active, Sort.by("active"));
    }


    public Adverts getAdverts(Long id) {
        return advertsRepository.getReferenceById(id);
    }


    public List<Adverts> getAllAdverts(){
        return advertsRepository.findAll(Sort.by("active"));
    }

    @Transactional
    public CreateAdvertsResponse createAdverts(CreateAdvertsRequestDTO createAdvertsRequestDTO)  {
        Adverts adverts = new Adverts(
                createAdvertsRequestDTO.getAdvertsDTO().getTitle(),
                createAdvertsRequestDTO.getAdvertsDTO().getImage(),
                createAdvertsRequestDTO.getAdvertsDTO().getDescription(),
                false
        );

        advertsRepository.save(adverts);

        return new CreateAdvertsResponse(
                adverts

        );
    }


    public UpdateAdvertsResponse updateAdvert(UpdateAdvertsRequestDTO updateAdvertsRequestDTO) {

        Adverts adverts = advertsRepository.getReferenceById(updateAdvertsRequestDTO.getId());
        adverts.setTitle(updateAdvertsRequestDTO.getTitle());
        adverts.setImage(updateAdvertsRequestDTO.getImage());
        adverts.setDescription(updateAdvertsRequestDTO.getDescription());
        adverts.setActive(updateAdvertsRequestDTO.getActive());


        advertsRepository.save(adverts);

        UpdateAdvertsResponse updateAdvertsResponse = new UpdateAdvertsResponse(
                adverts.getTitle(),
                adverts.getDescription(),
                adverts.getImage(),
                adverts.getActive()
        );

        return  updateAdvertsResponse;
    }
}
