package com.stackweb.web.stackweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stackweb.web.stackweb.entities.arrayListEntites;
import com.stackweb.web.stackweb.services.arrayServices;

@Controller
public class stackController {

    @Autowired
    private arrayServices arrayservices;
    
    @GetMapping("/home")
    public String startIndex(Model model)
    {
        model.addAttribute("structure", "home");
        return "home";
    }
    // For Arraylist page
    @GetMapping("/arraylist")
    public String getArrayList(Model model)
    {
        model.addAttribute("structure", "arraylist");
        return "arraylist";
    }
    // For Stack page
    @GetMapping("/stack")
    public String getStack(Model model)
    {
        model.addAttribute("structure", "stack");
        return "stack";
    }

    // PostMapping For Arraylist Insert Element
    @PostMapping("/arrayinsert")
    public String insertArrayElement(@ModelAttribute("arrayinsert") arrayListEntites aList, Model model)
    {  
        this.arrayservices.setEntity(aList); 
        model.addAttribute("structure", "arraylist");
        model.addAttribute("arr",this.arrayservices.getArr());
        System.out.println("List -1 :"+this.arrayservices.getArr());
        return "arraylist";
       
      }
      // PostMapping For Arraylist Show Element
      @PostMapping("/arrshow")
      public String showArray(@ModelAttribute("arrayinsert") arrayListEntites aList, Model model)
      {
        if (this.arrayservices.getArr().isEmpty())
        {
            model.addAttribute("arrerror", "mtylist");
        }
        model.addAttribute("structure", "arraylist");
        model.addAttribute("arr",this.arrayservices.getArr());
        return "arraylist";

      }
      // PostMapping For Reset page
      @PostMapping("/resetpage")
      public String restArrayList(@ModelAttribute("resetpage") arrayListEntites aList, Model model)
      {
        model.addAttribute("structure", "arraylist");
        return "arraylist";
      }
       // PostMapping For Reset page
      @PostMapping("/resetstack")
      public String restStack(@ModelAttribute("resetstack") arrayListEntites aList, Model model)
      {
        model.addAttribute("structure", "stack");
        return "stack";
      }
        // PostMapping For Push in Stack
      @PostMapping("/stackpush")
      public String arrayDelete(@ModelAttribute("arraydelete") arrayListEntites aList, Model model)
      {
        this.arrayservices.pushElement(aList); 
        model.addAttribute("structure", "stack");
        model.addAttribute("arr",this.arrayservices.getStack());
        System.out.println("List -2 :"+this.arrayservices.getStack());
        return "stack";
      }

        // PostMapping For Pop in Stack
      @PostMapping("/stackpop")
      public String stackPOP(@ModelAttribute("stackpop") arrayListEntites aList, Model model)
      {
        if (this.arrayservices.getStack().isEmpty())
        {
            model.addAttribute("stackerror", "stackmty");
        }
        this.arrayservices.popElement();
        model.addAttribute("structure", "stack");
        model.addAttribute("arr",this.arrayservices.getStack());
        System.out.println("List -2 :"+this.arrayservices.getStack());
        return "stack";
      }
        // PostMapping For Get Top Element
      @PostMapping("/stackpeek")
      public String stackPeek(@ModelAttribute("stackpeek") arrayListEntites aList, Model model)
      {
        if (this.arrayservices.getStack().isEmpty())
        {
            model.addAttribute("stackerror", "stackmty");
        }
        String topElement = this.arrayservices.peekElement();
        model.addAttribute("structure", "stack");
        model.addAttribute("topEle",topElement);
        System.out.println("List -2 :"+this.arrayservices.getStack());
        return "stack";
      }
        // PostMapping For Show Stack
      @PostMapping("/stackshow")
      public String stackShow(@ModelAttribute("stackshow") arrayListEntites aList, Model model)
      {
        if (this.arrayservices.getStack().isEmpty())
        {
            model.addAttribute("stackerror", "stackmty");
        }
        model.addAttribute("structure", "stack");
        model.addAttribute("arr",this.arrayservices.getStack());
        return "stack";
      }
     
    

    
}
