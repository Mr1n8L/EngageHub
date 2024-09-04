package com.engagehub.api.codegen.datafetchers;

import com.engagehub.api.codegen.types.Customer;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class CustomerDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "customer"
  )
  public Customer getCustomer(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
