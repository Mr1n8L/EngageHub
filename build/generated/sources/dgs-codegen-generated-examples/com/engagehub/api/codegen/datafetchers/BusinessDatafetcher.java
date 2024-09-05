package com.engagehub.api.codegen.datafetchers;

import com.engagehub.api.codegen.types.Business;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class BusinessDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "business"
  )
  public Business getBusiness(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
