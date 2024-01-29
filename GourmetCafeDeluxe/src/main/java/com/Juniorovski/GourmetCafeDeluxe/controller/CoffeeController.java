package com.Juniorovski.GourmetCafeDeluxe.controller;

import com.Juniorovski.GourmetCafeDeluxe.entity.Coffee;
import com.Juniorovski.GourmetCafeDeluxe.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;


@RequestMapping("/coffee")
@RestController
public class CoffeeController {

    private final String pathImage = "C:/Users/junio/OneDrive/Documentos/images";
    @Autowired
    private CoffeeService coffeeService;
    @CrossOrigin (origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<Coffee>>listAllCoffee(){
        List<Coffee> coffees = coffeeService.listAll();
        return  ResponseEntity.ok(coffees);
    }
    @CrossOrigin (origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Coffee> saveCoffee(@RequestBody Coffee coffee) {
        Coffee coffeeSaved = (Coffee) coffeeService.saveCoffee(coffee);

        return new ResponseEntity<>(coffeeSaved, HttpStatus.CREATED);
    }

   /* @PostMapping
    public ResponseEntity<Coffee> saveCoffee(
            @RequestParam("file") MultipartFile file,
            @RequestBody Coffee coffee) {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String filePath = pathImage + "/" + fileName;


            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);


            coffee.setImage(filePath);


            Coffee coffeeSaved = (Coffee) coffeeService.saveCoffee(coffee);

            return new ResponseEntity<>(coffeeSaved, HttpStatus.CREATED);
        } catch (IOException e) {
            // Tratar exceções de E/S (IOException)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            // Tratar outras exceções
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
*/
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Coffee>obterCoffee(@PathVariable Long id){
     Optional<Coffee> coffee = coffeeService.listAllId(id);
     return coffee.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
 }
}
