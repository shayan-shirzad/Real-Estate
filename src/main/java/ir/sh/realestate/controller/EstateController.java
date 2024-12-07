package ir.sh.realestate.controller;


import ir.sh.realestate.dto.EstateDTO;
import ir.sh.realestate.service.EstateService;
import ir.sh.realestate.service.impl.EstateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/estate")
public class EstateController {

    @Autowired
    private EstateService estateService;

    @PostMapping(value = "/create")
    public ResponseEntity addEstate(@Valid @RequestBody EstateDTO estateDTO)throws Exception {
            return ResponseEntity.ok(estateService.create(estateDTO));
    }

    @GetMapping(value = "/search")
    public ResponseEntity searchEstate(@RequestParam String trackingCode) throws Exception{
        return ResponseEntity.ok(estateService.search(trackingCode));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllEstate(){
        return ResponseEntity.ok(estateService.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteEstate(@PathVariable Long id){
        return ResponseEntity.ok(estateService.delete(id));
    }

    @PutMapping(value = "/update/{trackingCode}")
    public ResponseEntity updateEstate(@RequestBody EstateDTO estateDTO, @PathVariable String trackingCode) throws Exception{
        return ResponseEntity.ok(estateService.update(estateDTO, trackingCode));
    }




}
