package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class SubmitReviewGraphQLQuery extends GraphQLQuery {
  public SubmitReviewGraphQLQuery(String customerId, String businessId, int rating, String comment,
      String queryName, Set<String> fieldsSet) {
    super("mutation", queryName);
    if (customerId != null || fieldsSet.contains("customerId")) {
        getInput().put("customerId", customerId);
    }if (businessId != null || fieldsSet.contains("businessId")) {
        getInput().put("businessId", businessId);
    }getInput().put("rating", rating);                   if (comment != null || fieldsSet.contains("comment")) {
        getInput().put("comment", comment);
    }
  }

  public SubmitReviewGraphQLQuery() {
    super("mutation");
  }

  @Override
  public String getOperationName() {
     return "submitReview";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private String customerId;

    private String businessId;

    private int rating;

    private String comment;

    private String queryName;

    public SubmitReviewGraphQLQuery build() {
      return new SubmitReviewGraphQLQuery(customerId, businessId, rating, comment, queryName, fieldsSet);
               
    }

    public Builder customerId(String customerId) {
      this.customerId = customerId;
      this.fieldsSet.add("customerId");
      return this;
    }

    public Builder businessId(String businessId) {
      this.businessId = businessId;
      this.fieldsSet.add("businessId");
      return this;
    }

    public Builder rating(int rating) {
      this.rating = rating;
      this.fieldsSet.add("rating");
      return this;
    }

    public Builder comment(String comment) {
      this.comment = comment;
      this.fieldsSet.add("comment");
      return this;
    }

    public Builder queryName(String queryName) {
      this.queryName = queryName;
      return this;
    }
  }
}
