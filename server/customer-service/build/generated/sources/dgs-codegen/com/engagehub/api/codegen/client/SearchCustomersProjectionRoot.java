package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class SearchCustomersProjectionRoot<PARENT extends BaseSubProjectionNode<?, ?>, ROOT extends BaseSubProjectionNode<?, ?>> extends BaseSubProjectionNode<PARENT, ROOT> {
  public SearchCustomersProjectionRoot() {
    super(null, null, java.util.Optional.of("Customer"));
  }

  public SearchCustomersProjectionRoot<PARENT, ROOT> __typename() {
    getFields().put("__typename", null);
    return this;
  }

  public SearchCustomersProjectionRoot<PARENT, ROOT> id() {
    getFields().put("id", null);
    return this;
  }

  public SearchCustomersProjectionRoot<PARENT, ROOT> name() {
    getFields().put("name", null);
    return this;
  }

  public SearchCustomersProjectionRoot<PARENT, ROOT> email() {
    getFields().put("email", null);
    return this;
  }

  public SearchCustomersProjectionRoot<PARENT, ROOT> phoneNumber() {
    getFields().put("phoneNumber", null);
    return this;
  }
}
