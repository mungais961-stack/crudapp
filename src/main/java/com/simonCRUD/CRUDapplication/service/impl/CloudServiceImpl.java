package com.simonCRUD.CRUDapplication.service.impl;

import com.simonCRUD.CRUDapplication.model.CloudVendor;
import com.simonCRUD.CRUDapplication.repository.CloudVendorRepository;
import com.simonCRUD.CRUDapplication.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudServiceImpl implements CloudVendorService {
    CloudVendorRepository cloudVendorRepository;
    public CloudServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deleted Successfully";
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return  cloudVendorRepository.findAll();
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        return cloudVendorRepository.findById(cloudVendorId).get();
    }




}
