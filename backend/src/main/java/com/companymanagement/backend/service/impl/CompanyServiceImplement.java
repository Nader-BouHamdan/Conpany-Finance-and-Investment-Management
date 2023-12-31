package com.companymanagement.backend.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companymanagement.backend.model.Company;
import com.companymanagement.backend.repository.CompanyRepository;
import com.companymanagement.backend.service.CompanyService;

@Service
public class CompanyServiceImplement implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public String createCompany(Company company) {
        try {
            companyRepository.save(company);
            return "Successfully created";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to create company";
        }
    }

    @Override
    public String deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
        return "Successfully deleted";
    }

    @Override
    public List<Company> getAllCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Company getCompany(Long companyId) {
        return companyRepository.findById(companyId).get();
    }

    @Override
    public String updateCompany(Company company) {
        companyRepository.save(company);
        return "Successfully updated";
} 
}
