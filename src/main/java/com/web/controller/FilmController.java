package com.web.controller;

import com.config.AppConfig;
import com.model.Film;
import com.service.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FilmController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private FilmRepository filmRepository;


    @RequestMapping(value = "/filmList", method = RequestMethod.GET)
    public ModelAndView filmList(@RequestParam(defaultValue = "1") int page,ModelMap model) {
        Pageable pageable = PageRequest.of(page-1, AppConfig.PAGE_SIZE);
        ModelAndView modelAndView = new ModelAndView("filmList");
        Page<Film> filmPage=filmRepository.findAll(pageable);
        modelAndView.addObject("filmList", filmPage.getContent());
        modelAndView.addObject("currentPage",page);
        modelAndView.addObject("pageNumber",filmPage.getTotalPages());
        return modelAndView;
    }

    @RequestMapping(value = "/detailFilm")
    public ModelAndView detailFilm(@RequestParam long id, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("filmDetail");
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        List<Film> filmList = mongoTemplate.find(query, Film.class);
        if (filmList != null && filmList.size() == 1) {
            modelAndView.addObject("film",filmList.get(0));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/deleteFilm")
    public ModelAndView deleteFilm(@RequestParam long id, ModelMap model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        List<Film> filmList = mongoTemplate.find(query, Film.class);
        if (filmList != null && filmList.size() == 1) {
            mongoTemplate.remove(filmList.get(0));
        }
        return filmList(1,model);
    }

}
