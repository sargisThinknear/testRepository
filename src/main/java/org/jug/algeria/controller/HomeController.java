package org.jug.algeria.controller;

import org.jug.algeria.domain.MyItem;
import org.jug.algeria.domain.MyItemDesc;
import org.jug.algeria.repository.MyItemRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

  final MyItemRepository myItemRepository;

  @Inject
  public HomeController(MyItemRepository myItemRepository) {
    this.myItemRepository = myItemRepository;
  }

  @GetMapping
  public ModelAndView home() {
    return new ModelAndView("index");
  }

  @GetMapping(value = "/hello")
  public ResponseEntity<String> sayHello() {
    Long a =null;
    myItemRepository.findOne(123L);
    return ResponseEntity.ok().body("Hello there !");
  }

  @PostMapping(value = "/myItem/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MyItem> create(@PathVariable String username) {
    MyItem myItem = new MyItem();
    myItem.setName(username);


    MyItemDesc myItemDesc = new MyItemDesc();
    myItemDesc.setDescr(username + "___DESC___");

    myItem.setMyItemDesc(myItemDesc);

    MyItem saved = this.myItemRepository.save(myItem);
    return ResponseEntity.ok().body(saved);
  }

  @GetMapping(value = "/myItem", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<org.jug.algeria.domain.MyItem>> findAll() {
    final List<MyItem> resultList = new ArrayList<>();
    final Iterable<MyItem> all = myItemRepository.findAll();
    all.forEach(resultList::add);
    return ResponseEntity.ok().body(resultList);
  }

}
