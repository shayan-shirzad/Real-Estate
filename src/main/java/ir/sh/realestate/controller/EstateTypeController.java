package ir.sh.realestate.controller;

import ir.sh.realestate.dto.EstateTypeDTO;
import ir.sh.realestate.service.EstateTypeService;
import ir.sh.realestate.service.impl.EstateTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/estateType")
public class EstateTypeController {

    @Autowired
    private EstateTypeService estateTypeService;

    @PostMapping(value = "/create")
    public ResponseEntity addEstateType(@Valid @RequestBody EstateTypeDTO estateTypeDTO)throws Exception {
            return ResponseEntity.ok(estateTypeService.create(estateTypeDTO));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllEstateType(){
        return ResponseEntity.ok(estateTypeService.getAll());
    }

    @GetMapping(value = "/search")
    public ResponseEntity searchEstateType(@RequestParam Long id) throws Exception {
        return ResponseEntity.ok(estateTypeService.getById(id));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteEstateType(@PathVariable Long id){
        return ResponseEntity.ok(estateTypeService.delete(id));
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateEstateType(@RequestBody EstateTypeDTO estateTypeDTO) throws Exception{
        return ResponseEntity.ok(estateTypeService.update(estateTypeDTO));
    }
}
