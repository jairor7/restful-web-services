package com.tm.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties(value = {"field1", "field2"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {
  private String field1;
  private String field2;
  // @JsonIgnore
  private String field3;

  public SomeBean(String field1, String field2, String field3) {
    this.field1 = field1;
    this.field2 = field2;
    this.field3 = field3;
  }

  public String getField1() {
    return this.field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }

  public String getField2() {
    return this.field2;
  }

  public void setField2(String field2) {
    this.field2 = field2;
  }

  public String getField3() {
    return this.field3;
  }

  public void setField3(String field3) {
    this.field3 = field3;
  }
}
