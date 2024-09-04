package com.engagehub.api.codegen.datafetchers;

import com.engagehub.api.codegen.types.Review;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class ReviewsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "reviews"
  )
  public List<Review> getReviews(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
