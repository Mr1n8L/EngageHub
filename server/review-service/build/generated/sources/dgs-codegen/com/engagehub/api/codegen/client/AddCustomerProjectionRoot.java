package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class AddCustomerProjectionRoot<PARENT extends BaseSubProjectionNode<?, ?>, ROOT extends BaseSubProjectionNode<?, ?>> extends BaseSubProjectionNode<PARENT, ROOT> {
  public AddCustomerProjectionRoot() {
    super(null, null, java.util.Optional.of("Customer"));
  }

  public AddCustomerProjectionRoot<PARENT, ROOT> __typename() {
    getFields().put("__typename", null);
    return this;
  }

  public AddCustomerProjectionRoot<PARENT, ROOT> id() {
    getFields().put("id", null);
    return this;
  }

  public AddCustomerProjectionRoot<PARENT, ROOT> name() {
    getFields().put("name", null);
    return this;
  }

  public AddCustomerProjectionRoot<PARENT, ROOT> email() {
    getFields().put("email", null);
    return this;
  }

  public AddCustomerProjectionRoot<PARENT, ROOT> phoneNumber() {
    getFields().put("phoneNumber", null);
    return this;
  }
}
