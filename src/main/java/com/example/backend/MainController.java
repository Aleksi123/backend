package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api")
public class MainController {
  @Autowired 
  private TodoRepository todoRepository;

  @PostMapping(path="/add")
  public @ResponseBody String addNewTodo (@RequestParam String todo) {

    Todo n = new Todo();
    n.setTodo(todo);
    todoRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Todo> getAllTodos() {
    return todoRepository.findAll();
  }
}