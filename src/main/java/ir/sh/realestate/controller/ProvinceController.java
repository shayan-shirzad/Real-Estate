package ir.sh.realestate.controller;

import ir.sh.realestate.dto.ProvinceDTO;
import ir.sh.realestate.service.ProvinceService;
import ir.sh.realestate.service.impl.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/province")
public class ProvinceController {


    @Autowired
    private ProvinceService provinceService;

    @PostMapping(value = "/create")
    public ResponseEntity addProvince(@Valid @RequestBody ProvinceDTO provinceDTO)throws Exception {
            return ResponseEntity.ok(provinceService.create(provinceDTO));
    }

    @GetMapping(value = "/search")
    public ResponseEntity searchProvince(@RequestParam String provinceCode) throws Exception{
        return ResponseEntity.ok(provinceService.search(provinceCode));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllProvince(){
        return ResponseEntity.ok(provinceService.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteProvince(@PathVariable Long id){
        return ResponseEntity.ok(provinceService.delete(id));
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateProvince(@RequestBody ProvinceDTO provinceDTO) throws Exception{
        return ResponseEntity.ok(provinceService.update(provinceDTO));
    }

}
