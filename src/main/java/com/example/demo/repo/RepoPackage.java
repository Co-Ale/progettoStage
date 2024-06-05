package com.example.demo.repo;




import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.example.demo.entity.Package;

public interface RepoPackage extends CrudRepository <Package, Long>{
    List<Package> findByPallet_id(Long idPallet);
    @NonNull Optional<Package> findById(@NonNull Long id);

}