package com.tm.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  private Integer id;
  private Date dateCreatedPost;
  @Size(min = 5, message = "Description should have atleast 5 characters")
  private String description;
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User user;


  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getDateCreatedPost() {
    return this.dateCreatedPost;
  }

  public void setDateCreatedPost(Date dateCreatedPost) {
    this.dateCreatedPost = dateCreatedPost;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", description='" + getDescription() + "'" +
      "}";
  }

}
