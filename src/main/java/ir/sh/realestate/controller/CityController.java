package ir.sh.realestate.controller;

import ir.sh.realestate.dto.CityDTO;
import ir.sh.realestate.service.CityService;
import ir.sh.realestate.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping(value = "/create")
    public ResponseEntity addCity(@Valid @RequestBody CityDTO cityDTO)throws Exception {
            return ResponseEntity.ok(cityService.create(cityDTO));
    }

    @GetMapping(value = "/search")
    public ResponseEntity searchCity(@RequestParam String cityCode) throws Exception{
        return ResponseEntity.ok(cityService.search(cityCode));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllCity(){
        return ResponseEntity.ok(cityService.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCity(@PathVariable Long id){
        return ResponseEntity.ok(cityService.delete(id));
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateCity(@RequestBody CityDTO cityDTO) throws Exception{
        return ResponseEntity.ok(cityService.update(cityDTO));
    }

}
