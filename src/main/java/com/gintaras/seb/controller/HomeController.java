package com.gintaras.seb.controller;

import com.gintaras.seb.UtilsKt;
import com.gintaras.seb.model.Product;
import com.gintaras.seb.model.Questionnaire;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller that serves requests from UI.
 *
 * @author gintaras
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @PostMapping("/post")
    public ResponseEntity<List<Product>> handlePost(@RequestBody Questionnaire questionnaire) throws URISyntaxException {
        return new ResponseEntity<List<Product>>(UtilsKt.determinePossibleProduct(questionnaire)
                .stream().map(name -> new Product(name, UtilsKt.resolveProductCover(name)))
                .collect(Collectors.toList()), HttpStatus.CREATED);
    }

}

