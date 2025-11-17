package com.__4c_platform.platform.controller;

import com.__4c_platform.platform.entity.Demand;
import com.__4c_platform.platform.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/demand")
public class DemandController {

    @Autowired
    private DemandService demandService;

    @GetMapping("/list")
    public List<Demand> getAllDemands() {
        return demandService.getAllDemands();
    }

    @GetMapping("/publisher/{publisherId}")
    public List<Demand> getDemandsByPublisher(@PathVariable Long publisherId) {
        return demandService.getDemandsByPublisher(publisherId);
    }

    @PostMapping("/publish")
    public Map<String, Object> publishDemand(@RequestBody Demand demand) {
        Map<String, Object> result = new HashMap<>();
        boolean success = demandService.publishDemand(demand);
        result.put("success", success);
        result.put("message", success ? "需求发布成功" : "需求发布失败");
        return result;
    }
}