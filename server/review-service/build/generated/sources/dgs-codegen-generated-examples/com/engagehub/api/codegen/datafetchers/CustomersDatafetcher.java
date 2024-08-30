package com.engagehub.api.codegen.datafetchers;

import com.engagehub.api.codegen.types.Customer;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class CustomersDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "customers"
  )
  public List<Customer> getCustomers(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
