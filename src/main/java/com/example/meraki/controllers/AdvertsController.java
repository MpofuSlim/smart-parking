package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateAdvertsRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdvertsRequestDTO;
import com.example.meraki.entities.Adverts;
import com.example.meraki.services.AdvertsService;
import com.example.meraki.services.response.CreateAdvertsResponse;
import com.example.meraki.services.response.UpdateAdvertsResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvertsController {
    @Autowired
    private AdvertsService advertsService;

    @CrossOrigin
    @PostMapping(path = "/adverts/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Adverts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    private Response<CreateAdvertsResponse> createAdvertsId(@RequestBody CreateAdvertsRequestDTO createAdvertsRequestDTO) {

        CreateAdvertsResponse  createAdvertsResponse = advertsService.createAdverts(createAdvertsRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Advert added.", createAdvertsResponse);
    }
    @CrossOrigin
    @GetMapping(path = "/adverts/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all adverts", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<Adverts>> listAdverts(   ) {
        List<Adverts> advert;

        advert = advertsService.getAllAdverts();

        return new Response<>(ResponseCode.SUCCESS, "OK", advert);
    }


    @CrossOrigin
    @GetMapping(path = "/active/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve advert by id.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Adverts>> getAdvertsById(
            @ApiParam(value = "active", example = "1", required = true)
            @PathVariable Long id) {

        List<Adverts> advertsList = advertsService.getActiveById(id);

        return new Response<>(ResponseCode.SUCCESS, "OK", advertsList);

    }

    @CrossOrigin
    @GetMapping(path = "/adverts/{active}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve adverts by active.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Adverts>> getAdvertsByActive(
            @ApiParam(value = "bundle", example = "false", required = true)
            @PathVariable Boolean active) {

        List<Adverts> activeList = advertsService.getAdvertsByActive(active);

        return new Response<>(ResponseCode.SUCCESS, "OK", activeList);

    }



    @CrossOrigin
    @PutMapping("/adverts/{id}")
    @ApiParam(value = "update adverts", example = "", required = true)
    public Response<UpdateAdvertsResponse> updateAdverts(
            @RequestBody UpdateAdvertsRequestDTO updateAdvertsRequestDTO) {
        UpdateAdvertsResponse response =  advertsService.updateAdvert(updateAdvertsRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }


}

