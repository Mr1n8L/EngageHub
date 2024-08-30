package com.engagehub.api.codegen;

import java.lang.String;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static final String MUTATION_TYPE = "Mutation";

  public static class CUSTOMER {
    public static final String TYPE_NAME = "Customer";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Email = "email";

    public static final String PhoneNumber = "phoneNumber";
  }

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String Customers = "customers";

    public static final String CustomerById = "customerById";

    public static final String SearchCustomers = "searchCustomers";

    public static class CUSTOMERBYID_INPUT_ARGUMENT {
      public static final String Id = "id";
    }

    public static class SEARCHCUSTOMERS_INPUT_ARGUMENT {
      public static final String Name = "name";

      public static final String Email = "email";

      public static final String PhoneNumber = "phoneNumber";
    }
  }

  public static class MUTATION {
    public static final String TYPE_NAME = "Mutation";

    public static final String AddCustomer = "addCustomer";

    public static final String UpdateCustomer = "updateCustomer";

    public static final String DeleteCustomer = "deleteCustomer";

    public static class ADDCUSTOMER_INPUT_ARGUMENT {
      public static final String Name = "name";

      public static final String Email = "email";

      public static final String PhoneNumber = "phoneNumber";
    }

    public static class UPDATECUSTOMER_INPUT_ARGUMENT {
      public static final String Id = "id";

      public static final String Name = "name";

      public static final String Email = "email";

      public static final String PhoneNumber = "phoneNumber";
    }

    public static class DELETECUSTOMER_INPUT_ARGUMENT {
      public static final String Id = "id";
    }
  }
}
