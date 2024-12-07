package ir.sh.realestate.controller;

import ir.sh.realestate.dto.AddressDTO;
import ir.sh.realestate.service.AddressService;
import ir.sh.realestate.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/create")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTO)throws Exception {
            return ResponseEntity.ok(addressService.create(addressDTO));
    }

    @GetMapping(value = "/search")
    public ResponseEntity searchAddress(@RequestParam String postalCode) throws Exception{
        return ResponseEntity.ok(addressService.search(postalCode));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.ok(addressService.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Long id){
        return ResponseEntity.ok(addressService.delete(id));
    }

    @PutMapping(value ="/update/{postalCode}")
    public ResponseEntity updateAddress(@RequestBody AddressDTO addressDTO, @PathVariable String postalCode) throws Exception{
        return ResponseEntity.ok(addressService.update(addressDTO, postalCode));
    }

}
