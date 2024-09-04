package com.engagehub.api.codegen;

import java.lang.String;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static final String MUTATION_TYPE = "Mutation";

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String Reviews = "reviews";

    public static final String ReviewById = "reviewById";

    public static class REVIEWBYID_INPUT_ARGUMENT {
      public static final String Id = "id";
    }
  }

  public static class MUTATION {
    public static final String TYPE_NAME = "Mutation";

    public static final String SubmitReview = "submitReview";

    public static final String RespondToReview = "respondToReview";

    public static class SUBMITREVIEW_INPUT_ARGUMENT {
      public static final String CustomerId = "customerId";

      public static final String BusinessId = "businessId";

      public static final String Rating = "rating";

      public static final String Comment = "comment";
    }

    public static class RESPONDTOREVIEW_INPUT_ARGUMENT {
      public static final String ReviewId = "reviewId";

      public static final String Response = "response";
    }
  }

  public static class REVIEW {
    public static final String TYPE_NAME = "Review";

    public static final String Id = "id";

    public static final String CustomerId = "customerId";

    public static final String BusinessId = "businessId";

    public static final String Rating = "rating";

    public static final String Comment = "comment";

    public static final String Response = "response";
  }
}
