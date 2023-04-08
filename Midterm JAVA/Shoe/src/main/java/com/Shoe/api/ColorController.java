package com.Shoe.api;

import com.Shoe.model.Color;
import com.Shoe.model.Size;
import com.Shoe.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin/color")
public class ColorController {
    @Autowired
    private ColorService colorService;
    @GetMapping("/getAll")
    public List<Color> getColorAll(){
        return colorService.getAll();
    }
    @GetMapping("/getColor/{id}")
    public Color getColorByID(@PathVariable("id") Long id){
        return  colorService.getColorByID(id);
    }
    @PostMapping("/updateColor")
    public Color update(@RequestParam Map<String,String > paramas){
        Color Color = new Color();
        Color.setName(paramas.get("name"));
        Color.setColorId(Long.valueOf(paramas.get("id")));
        return colorService.update(Color);
    }
    @RequestMapping(value = "/deleteColor/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id){
        return colorService.delete(id);
    }

    @PostMapping("/addColor")
    public Color addColor(@RequestParam("name") String name){
        Color color = new Color();
        color.setName(name);
        return colorService.addColor(color);
    }

}
