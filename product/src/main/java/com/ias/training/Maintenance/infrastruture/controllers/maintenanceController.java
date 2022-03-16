package com.ias.training.Maintenance.infrastruture.controllers;



import com.ias.training.Maintenance.infrastruture.controllers.models.MaintenanceDTO;
import com.ias.training.Maintenance.infrastruture.controllers.models.MaintenanceInput;


import com.ias.training.Maintenance.infrastruture.services.MaintenanceServices;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class maintenanceController {
    private final MaintenanceServices maintenanceServices;

    public maintenanceController(MaintenanceServices maintenanceServices) {
        this.maintenanceServices = maintenanceServices;
    }


    @RequestMapping(value = "/service", method = RequestMethod.POST)
    public MaintenanceDTO createMaintenance(@RequestBody MaintenanceInput maintenanceInput) {
        return maintenanceServices.createService(maintenanceInput);
    }

    @RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
    public Optional<MaintenanceDTO> getMaintenance(@PathVariable("id") String maintenanceId) {
        return maintenanceServices.getService(maintenanceId);
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public List<MaintenanceDTO> listMaintenance(
            @RequestParam(name = "skip", defaultValue = "0") Integer skip,
            @RequestParam(name = "limit", defaultValue = "50") Integer limit
    ) {
        return maintenanceServices.queryServices(skip, limit);
    }


}
