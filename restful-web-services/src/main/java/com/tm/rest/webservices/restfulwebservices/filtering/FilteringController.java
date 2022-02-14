package com.tm.rest.webservices.restfulwebservices.filtering;

import java.util.List;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.Arrays;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

  private MappingJacksonValue mappingFilter(Object someBean, String... fields) {
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
    MappingJacksonValue mapping = new MappingJacksonValue(someBean);
    mapping.setFilters(filters);
    return mapping;
  }

  // Send field1 and field2
  @GetMapping("/filtering")
  public MappingJacksonValue retrieveSomeBean() {
    SomeBean someBean = new SomeBean("value1", "value2", "value3");
    return mappingFilter(someBean, "field1", "field2");
  }

  // Send field2 and field3
  @GetMapping("/filtering-list")
  public MappingJacksonValue retrieveListSomeBean() {
    List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value12", "value22", "value32"));
    return mappingFilter(list, "field2", "field3");
  }


}
