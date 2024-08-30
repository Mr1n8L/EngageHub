package com.engagehub.api.codegen.datafetchers;

import com.engagehub.api.codegen.types.Customer;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class CustomerByIdDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "customerById"
  )
  public Customer getCustomerById(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
