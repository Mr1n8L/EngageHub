package com.engagehub.api.codegen;

import java.lang.String;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static final String MUTATION_TYPE = "Mutation";

  public static class BUSINESS {
    public static final String TYPE_NAME = "Business";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Address = "address";

    public static final String Type = "type";

    public static final String ContactInformation = "contactInformation";
  }

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String Businesses = "businesses";

    public static final String Business = "business";

    public static class BUSINESS_INPUT_ARGUMENT {
      public static final String Id = "id";
    }
  }

  public static class MUTATION {
    public static final String TYPE_NAME = "Mutation";

    public static final String AddBusiness = "addBusiness";

    public static final String UpdateBusiness = "updateBusiness";

    public static final String DeleteBusiness = "deleteBusiness";

    public static class ADDBUSINESS_INPUT_ARGUMENT {
      public static final String Name = "name";

      public static final String Address = "address";

      public static final String Type = "type";

      public static final String ContactInformation = "contactInformation";
    }

    public static class UPDATEBUSINESS_INPUT_ARGUMENT {
      public static final String Id = "id";

      public static final String Name = "name";

      public static final String Address = "address";

      public static final String Type = "type";

      public static final String ContactInformation = "contactInformation";
    }

    public static class DELETEBUSINESS_INPUT_ARGUMENT {
      public static final String Id = "id";
    }
  }
}
