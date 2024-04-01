package com.devhamzat.enrollment.repository;

import com.devhamzat.enrollment.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<Address> findByHouseNumberAndStreetAndStateAndAndCountry(Integer integer, String street, String state,String country);
}
