package com.simonCRUD.CRUDapplication.service;

import com.simonCRUD.CRUDapplication.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudvendorId);
    public List<CloudVendor> getAllCloudVendor();
    public CloudVendor getCloudVendor(String cloudVendorId);


}
