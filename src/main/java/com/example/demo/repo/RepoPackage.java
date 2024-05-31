package com.example.demo.repo;



import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Package;

public interface RepoPackage extends CrudRepository<Package, Long>{

}