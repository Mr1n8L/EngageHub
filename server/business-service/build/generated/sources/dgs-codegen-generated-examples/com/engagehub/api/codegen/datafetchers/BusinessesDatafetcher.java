package com.engagehub.api.codegen.datafetchers;

import com.engagehub.api.codegen.types.Business;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class BusinessesDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "businesses"
  )
  public List<Business> getBusinesses(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
