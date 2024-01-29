package com.Juniorovski.GourmetCafeDeluxe.service;

import com.Juniorovski.GourmetCafeDeluxe.entity.Coffee;
import com.Juniorovski.GourmetCafeDeluxe.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<Coffee> saveCoffee(Coffee coffee){

        coffeeRepository.save(coffee);
        return  null;
    }
    public List<Coffee> listAll(){
       return coffeeRepository.findAll();
    }

    public Optional<Coffee> listAllId(Long id){
       return coffeeRepository.findAllById(id);

    }
    public List<Coffee>update(Coffee coffee){
        coffeeRepository.save(coffee);
        return null;
    }
    public List<Coffee>delete(Long id){
        coffeeRepository.deleteById(id);
        return null;
    }
}
