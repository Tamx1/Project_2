package com.example.Test1.Cars;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(path= "cars")
public class CarController {

    ArrayList<Car> cars = new ArrayList<>();

    @GetMapping("/getCarsByColor")
    public List<Car> getCarsByColor(@RequestBody String color) {
        ArrayList<Car> carsSelect = new ArrayList<>();
        for (int i = 0 ; i < cars.size() ; i++){
            if (cars.get(i).getColor().equals(color)){
                carsSelect.add(cars.get(i));}
        }
        return carsSelect;
    }

    @GetMapping("/getCarsByCYearOfMake")
    public List<Car> getCarsByYearOfMake(@RequestBody String yearOfMake) {
        ArrayList<Car> carsSelect = new ArrayList<>();
        for (int i = 0 ; i < cars.size() ; i++){
            if (cars.get(i).getYearOfMake().equals(yearOfMake)){
                carsSelect.add(cars.get(i));}
        }
        return carsSelect;
    }

    @GetMapping("/getCarsByPrice")
    public List<Car> getCarsByPrice(@RequestBody String price) {
        ArrayList<Car> carsSelect = new ArrayList<>();
        for (int i = 0 ; i < cars.size() ; i++){
            if (cars.get(i).getPrice() == Double.valueOf(price)){
                carsSelect.add(cars.get(i));}
        }
        return carsSelect;
    }


    @GetMapping("/buyCar/{id}")
    public ResponseEntity buyCar(@RequestBody String price, @PathVariable String id) {
        for (int i = 0 ; i < cars.size() ; i++){
            if (cars.get(i).getId() == Integer.valueOf(id)){

                if (Double.valueOf(price) == cars.get(i).getPrice()){
                    return ResponseEntity.status(200).body("Buying succeeded");
                }
                if (Double.valueOf(price) >= cars.get(i).getPrice()){
                    return ResponseEntity.status(200).body("Buying succeeded. The rest of the amount :" + (Double.valueOf(price) - cars.get(i).getPrice()));
                }

            }
        }
        return ResponseEntity.status(400).body("Request has been rejected");
    }

    @GetMapping()
    public List<Car> getCars(@RequestBody String yearOfMake) {
        return cars;
    }

    @PostMapping
    public ResponseEntity addCar(@RequestBody Car car) {
        cars.add(car);
        return ResponseEntity.status(200).body("Car added");
    }

    @DeleteMapping()
    public ResponseEntity delCarLessThanFive() {
        Date date = new Date();

        for (int i = 0 ; i < cars.size() ; i++){
            if(Calendar.getInstance().get(Calendar.YEAR) - Integer.valueOf(cars.get(i).getYearOfMake()) < 5){
                cars.remove(i);
            }
        }

        return ResponseEntity.status(200).body("Cars have been deleted");
    }




}