package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.codegym.service.*;
import com.codegym.model.*;

@Controller
@RequestMapping ("/product")
public class ProductController {
    private ProductService productService =new ProductService();
    @GetMapping
    public String index(Model model){
        model.addAttribute("products",productService.fillAll());
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product , RedirectAttributes redirect){
        int id= (++productService.key);
        product.setId(id);
        productService.save(product);
        redirect.addFlashAttribute("message", "Saved product successfully!");
        return "redirect:/product";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Product product, RedirectAttributes redirect){
        int id =product.getId();
        productService.update(product.getId(),product);
        redirect.addFlashAttribute("message","Edited product successfully");
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        return "delete";
    }
    @PostMapping("/remove")
    public String remove(Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("message","Deleted product successfully");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        return "view";
    }

}
