package com.engagehub.api.codegen.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Review {
  private String id;

  private String customerId;

  private String businessId;

  private int rating;

  private String comment;

  private String response;

  public Review() {
  }

  public Review(String id, String customerId, String businessId, int rating, String comment,
      String response) {
    this.id = id;
    this.customerId = customerId;
    this.businessId = businessId;
    this.rating = rating;
    this.comment = comment;
    this.response = response;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getBusinessId() {
    return businessId;
  }

  public void setBusinessId(String businessId) {
    this.businessId = businessId;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  @Override
  public String toString() {
    return "Review{" + "id='" + id + "'," +"customerId='" + customerId + "'," +"businessId='" + businessId + "'," +"rating='" + rating + "'," +"comment='" + comment + "'," +"response='" + response + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review that = (Review) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(customerId, that.customerId) &&
                            java.util.Objects.equals(businessId, that.businessId) &&
                            rating == that.rating &&
                            java.util.Objects.equals(comment, that.comment) &&
                            java.util.Objects.equals(response, that.response);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, customerId, businessId, rating, comment, response);
  }

  public static com.engagehub.api.codegen.types.Review.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String customerId;

    private String businessId;

    private int rating;

    private String comment;

    private String response;

    public Review build() {
                  com.engagehub.api.codegen.types.Review result = new com.engagehub.api.codegen.types.Review();
                      result.id = this.id;
          result.customerId = this.customerId;
          result.businessId = this.businessId;
          result.rating = this.rating;
          result.comment = this.comment;
          result.response = this.response;
                      return result;
    }

    public com.engagehub.api.codegen.types.Review.Builder id(String id) {
      this.id = id;
      return this;
    }

    public com.engagehub.api.codegen.types.Review.Builder customerId(String customerId) {
      this.customerId = customerId;
      return this;
    }

    public com.engagehub.api.codegen.types.Review.Builder businessId(String businessId) {
      this.businessId = businessId;
      return this;
    }

    public com.engagehub.api.codegen.types.Review.Builder rating(int rating) {
      this.rating = rating;
      return this;
    }

    public com.engagehub.api.codegen.types.Review.Builder comment(String comment) {
      this.comment = comment;
      return this;
    }

    public com.engagehub.api.codegen.types.Review.Builder response(String response) {
      this.response = response;
      return this;
    }
  }
}
