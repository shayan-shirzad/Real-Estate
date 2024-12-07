package ir.sh.realestate.controller;

import ir.sh.realestate.dto.OwnerTypeDTO;
import ir.sh.realestate.service.OwnerTypeService;
import ir.sh.realestate.service.impl.OwnerTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/ownerType")
public class OwnerTypeController {

    @Autowired
    private OwnerTypeService ownerTypeService;

    @PostMapping(value = "/create")
    public ResponseEntity addOwnerType(@Valid @RequestBody OwnerTypeDTO ownerTypeDTO)throws Exception {
            return ResponseEntity.ok(ownerTypeService.create(ownerTypeDTO));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllOwnerType(){
        return ResponseEntity.ok(ownerTypeService.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteOwnerType(@PathVariable Long id){
        return ResponseEntity.ok(ownerTypeService.delete(id));
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateOwnerType(@RequestBody OwnerTypeDTO ownerTypeDTO) throws Exception{
        return ResponseEntity.ok(ownerTypeService.update(ownerTypeDTO));
    }
}