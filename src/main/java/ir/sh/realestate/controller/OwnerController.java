package ir.sh.realestate.controller;

import ir.sh.realestate.dto.OwnerDTO;
import ir.sh.realestate.service.OwnerService;
import ir.sh.realestate.service.impl.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping(value = "/create")
    public ResponseEntity addOwner(@Valid @RequestBody OwnerDTO ownerDTO)throws Exception {
            return ResponseEntity.ok(ownerService.create(ownerDTO));
    }

    @GetMapping(value = "/search")
    public ResponseEntity searchOwner(@RequestParam String nationalCode) throws Exception{
        return ResponseEntity.ok(ownerService.search(nationalCode));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllOwner(){
        return ResponseEntity.ok(ownerService.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteOwner(@PathVariable Long id){
        return ResponseEntity.ok(ownerService.delete(id));
    }

    @PutMapping(value = "/update/{nationalCode}")
    public ResponseEntity updateOwner(@RequestBody OwnerDTO ownerDTO,@PathVariable String nationalCode) throws Exception{
        return ResponseEntity.ok(ownerService.update(ownerDTO, nationalCode));
    }

}
