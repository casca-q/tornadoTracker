package com.tracker.tornado.controller;

import com.tracker.tornado.model.FujitaScale;
import com.tracker.tornado.model.Tornado;
import com.tracker.tornado.service.LocationService;
import com.tracker.tornado.service.TornadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TornadoController {

    private final TornadoService tornadoService;
    private final LocationService locationService;

    public TornadoController(TornadoService tornadoService, LocationService locationService) {
        this.tornadoService = tornadoService;
        this.locationService = locationService;
    }

    @GetMapping("/tornadoes")
    public String listTornadoes(Model model) {
        model.addAttribute("tornadoes", tornadoService.findAll());
        model.addAttribute("locationService", locationService);
        return "tornadoes";
    }

    @GetMapping("/tornadoes/add")
    public String showAddForm(Model model) {
        model.addAttribute("tornado", new Tornado());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("scales", FujitaScale.values());
        model.addAttribute("pageTitle", "Add New Tornado");
        return "tornado-form";
    }

    @PostMapping("/tornadoes/save")
    public String saveTornado(@ModelAttribute("tornado") Tornado tornado) {
        tornadoService.save(tornado);
        return "redirect:/tornadoes";
    }

    @GetMapping("/tornadoes/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Tornado tornado = tornadoService.findById(id);
        model.addAttribute("tornado", tornado);
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("scales", FujitaScale.values());
        model.addAttribute("pageTitle", "Edit Tornado Data");
        return "tornado-form";
    }

    @GetMapping("/tornadoes/delete/{id}")
    public String deleteTornado(@PathVariable Long id) {
        tornadoService.deleteById(id);
        return "redirect:/tornadoes";
    }
} 