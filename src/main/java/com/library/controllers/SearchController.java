package com.library.controllers;

import com.library.DAO.FilmDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/films")
public class SearchController {

    private FilmDAO filmDAO;

    @Autowired
    public SearchController(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(value="directorLastName", required=false) String directorLastName,
                         @RequestParam(value="yearFrom", required=false) String yearFrom,
                         @RequestParam(value="yearUntil", required=false) String yearUntil,
                         Model model) {
        model.addAttribute("films", filmDAO.search(directorLastName, yearFrom, yearUntil));
        return "films/form";
    }
}