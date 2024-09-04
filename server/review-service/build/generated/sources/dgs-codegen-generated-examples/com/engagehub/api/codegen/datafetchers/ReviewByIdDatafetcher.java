package com.engagehub.api.codegen.datafetchers;

import com.engagehub.api.codegen.types.Review;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class ReviewByIdDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "reviewById"
  )
  public Review getReviewById(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
