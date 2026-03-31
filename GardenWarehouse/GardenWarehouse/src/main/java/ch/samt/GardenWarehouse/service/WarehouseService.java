package ch.samt.GardenWarehouse.service;


import ch.samt.GardenWarehouse.data.WarehouseRepository;
import ch.samt.GardenWarehouse.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository) {this.warehouseRepository = warehouseRepository;}

    public List<Item> getAllItems() {return warehouseRepository.findAll();}
    public void saveItem(Item item) {warehouseRepository.save(item);}
    public Optional<Item> getItemByCode(String code) {return warehouseRepository.findFirstByCode(code);}

    public void sellItemByCode(String code) {
        Optional<Item> optionalItem = warehouseRepository.findFirstByCode(code);
        if(optionalItem.isPresent()) {
            Item item = optionalItem.get();
            if(item.getItemCount() > 1) {
                item.setItemCount(item.getItemCount() - 1);
            }
            warehouseRepository.save(item);
        }
    }
    public void addItemByCode(String code, int number) {
        Optional<Item> optionalItem = warehouseRepository.findFirstByCode(code);
        if(optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setItemCount(item.getItemCount() + number);
            warehouseRepository.save(item);
        }
    }

}
