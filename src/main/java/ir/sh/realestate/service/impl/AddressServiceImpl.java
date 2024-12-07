package ir.sh.realestate.service.impl;

import ir.sh.realestate.dao.AddressDAO;
import ir.sh.realestate.dto.AddressDTO;
import ir.sh.realestate.entity.AddressEntity;
import ir.sh.realestate.exception.AlreadyExistsException;
import ir.sh.realestate.exception.NotFoundException;
import ir.sh.realestate.exception.NullPointerException;
import ir.sh.realestate.mapper.AddressMapper;
import ir.sh.realestate.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Boolean findPostalCodeExists(String postalCode) throws Exception {
        if (addressDAO.existsByPostalCodeEquals(postalCode))
            return true;
        else
            return false;
    }

    @Transactional
    @Override
    public AddressDTO create(AddressDTO addressDTO) throws Exception {
        if (addressDTO.getPostalCode() == null) {
            throw new NullPointerException("فیلد کد پستی را پر کنید");
        }
        else {
            if (!this.findPostalCodeExists(addressDTO.getPostalCode())) {
                AddressEntity addressEntity = addressDAO.save(addressMapper.convertToEntity(addressDTO));
                return addressMapper.convertToDTO(addressEntity);
            } else {
                throw new AlreadyExistsException("آدرسی با کد پستی " + addressDTO.getPostalCode() + " در سامانه وجود دارد");
            }
        }
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO, String postalCode) throws Exception {
        if (addressDAO.existsByPostalCodeEquals(postalCode)) {
            AddressEntity addressEntity = addressDAO.findByPostalCode(postalCode);
            addressEntity.setCreatedTime(new Date());
            if (addressDTO.getStreet() != null)
                addressEntity.setStreet(addressDTO.getStreet());

            if (addressDTO.getAlley() != null)
                addressEntity.setAlley(addressDTO.getAlley());

            return addressMapper.convertToDTO(addressDAO.save(addressEntity));
        } else throw new NotFoundException("آدرسی با کد پستی " + postalCode + " در سامانه وجود ندارد");
    }

    @Override
    public Boolean delete(Long id) {
        addressDAO.deleteById(id);
        return true;
    }

    @Override
    public AddressDTO search(String postalCode) throws Exception {
        return addressMapper.convertToDTO(addressDAO.findByPostalCode(postalCode));
    }

    @Override
    public List<AddressDTO> getAll() {
        return addressMapper.convertToDTO((List) addressDAO.findAll());
    }

//    @Override
//    public List<AddressDTO> getAll() {
//        return addressMapper.convertToDTO((List) addressDAO.findByOrderByStreetAsc());
//    }

}
