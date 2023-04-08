package com.Shoe.api;

import com.Shoe.model.Genre;
import com.Shoe.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/getAll")
    public List<Genre>   getAllGenre(){
        return genreService.getAll();

    }
    @PostMapping("/addGenre")
    public Genre add(@RequestParam Map<String ,String> paramas){
        Genre genre =  new Genre();
        genre.setName(paramas.get("name"));
        return  genreService.add(genre);
    }
    @PostMapping("/updateGenre")

    public Genre update(@RequestParam Map<String ,String> paramas){
        Genre genre =  new Genre();
        genre.setName(paramas.get("name"));
        genre.setGenreId(Long.valueOf(paramas.get("id")));

        return  genreService.update(genre);
    }
    @RequestMapping(value = "/deleteGenre/{id}",method = RequestMethod.DELETE)
    public String deleteGenre(@PathVariable("id") Long id){
        return genreService.delete(id);
    }
    @RequestMapping(value = "/getGenre/{id}",method = RequestMethod.GET)
    public Genre getGenreById(@PathVariable("id") Long id){
        return genreService.getGenreByID(id);
    }

}
