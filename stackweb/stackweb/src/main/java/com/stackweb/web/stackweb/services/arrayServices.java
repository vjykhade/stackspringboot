package com.stackweb.web.stackweb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Component;

import com.stackweb.web.stackweb.entities.arrayListEntites;
@Component
public class arrayServices {
    private List<arrayListEntites> list = new ArrayList<>();
    private final Stack stack = new Stack<>();

    public void setEntity(arrayListEntites arr)
    {
        list.add(arr);
        System.err.println(list);
    }

    public List<arrayListEntites> getArr()
    {
        return list;
    }

   public void pushElement(arrayListEntites arr)
   {
        System.out.print("Enter value to push in stack: ");
        stack.push(arr);
        System.err.println("Element pushed in stack successfully.");
   }
   public Stack<arrayListEntites> getStack()
   {
      return stack;
   }
   public void popElement()
   {
    if (stack.isEmpty())
    {
        System.out.println("Stack is empty");
    }
    else
    {
        stack.pop();
    }
   }
    public String peekElement()
    {
        String topElement = "";
        if (stack.isEmpty())
        {
            System.out.println("Stack is empty");
        }
        else
        {
            topElement = stack.peek().toString();
        }
       
       return topElement;
    }
}
