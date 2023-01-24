package com.example.meraki.services;

import com.example.meraki.common.updaterequests.UpdateBundleRequestDTO;
import com.example.meraki.entities.*;
import com.example.meraki.repositories.*;
import com.example.meraki.services.response.UpdateBundleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.example.meraki.common.createrequests.CreateBundlesRequestDTO;
import com.example.meraki.services.response.CreateBundlesResponse;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;


@Service
public class BundlesService {

    private boolean quit = false;

    @Autowired
    protected CustomersRepository custDB;

    @Autowired
    private BundlesRepository bundlesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private BundlesCategoryRepository bundlesCategoryRepository;

    public BundlesService(BundlesRepository bundlesRepository) {
        this.bundlesRepository = bundlesRepository;
    }

    public List<Bundles> getAllBundles() {
        return bundlesRepository.findAll();
    }


    public List<Bundles> getBundleByBundleId(Long id) {
        return bundlesRepository.findByid(id);
    }

    public List<Bundles> getBundlesByActive(Boolean active) {
        return bundlesRepository.findByActive(active);
    }

    public Bundles getBundle(Long id) {
        return bundlesRepository.getReferenceById(id);
    }


    public Bundles getBundlesById(Long id) {
        return bundlesRepository.getReferenceById(id);
    }


    public boolean checkBundleExistsInCategory(Long id, BundleCategoryService bundleCategoryService) {
        boolean result = false;

        try {
            bundlesRepository.findByBundleCategory(bundleCategoryService.getBundlesCategory(id));
        } catch (EntityNotFoundException entityNotFoundException) {
            result = true;
        }
        return result;
    }


    public List<Bundles> getBundlesByCategory(BundleCategory category) {
        return bundlesRepository.findByBundleCategory(category);
    }


    @Transactional
    public CreateBundlesResponse createBundles(CreateBundlesRequestDTO createBundlesRequestDTO) throws IOException {
        User user1 = userRepository.getReferenceById(createBundlesRequestDTO.getUserID());
        Currency currency1 = currencyRepository.getReferenceById(createBundlesRequestDTO.getCurrencyID());
        BundleCategory bundlesCategory1 = bundlesCategoryRepository.getReferenceById(createBundlesRequestDTO.getBundleCategoryID());
        Bundles bundles = new Bundles(
                user1,
                currency1,
                bundlesCategory1,
                createBundlesRequestDTO.getBundle().getName(),
                createBundlesRequestDTO.getBundle().getGroupPolicyId(),
                createBundlesRequestDTO.getBundle().getDescription(),
                createBundlesRequestDTO.getBundle().getImage(),
                createBundlesRequestDTO.getBundle().getPrice(),
                false
        );

        bundlesRepository.save(bundles);

        return new CreateBundlesResponse(
                bundles,
                user1,
                currency1,
                bundlesCategory1
        );

    }

    public UpdateBundleResponse updateBundle(UpdateBundleRequestDTO updateBundleRequestDTO) {

        Bundles bundles = bundlesRepository.getReferenceById(updateBundleRequestDTO.getId());
        bundles.setName(updateBundleRequestDTO.getName());
        bundles.setDescription(updateBundleRequestDTO.getDescription());
        bundles.setImage(updateBundleRequestDTO.getImage());
        bundles.setPrice(updateBundleRequestDTO.getPrice());
        bundles.setGroupPolicyId(updateBundleRequestDTO.getGroupPolicyId());
        bundles.setActive(updateBundleRequestDTO.getActive());
        bundles.setBundleCategory(bundlesCategoryRepository.getReferenceById(updateBundleRequestDTO.getBundleCategoryId()));
        bundles.setCurrency(currencyRepository.getReferenceById(updateBundleRequestDTO.getCurrencyId()));

        bundlesRepository.save(bundles);

        UpdateBundleResponse updateBundleResponse = new UpdateBundleResponse(
                bundles.getBundleCategory().getId(),
                bundles.getCurrency().getId(),
                bundles.getName(),
                bundles.getDescription(),
                bundles.getImage(),
                bundles.getPrice(),
                bundles.getGroupPolicyId(),
                bundles.getActive()
        );

        return updateBundleResponse;
    }
}





