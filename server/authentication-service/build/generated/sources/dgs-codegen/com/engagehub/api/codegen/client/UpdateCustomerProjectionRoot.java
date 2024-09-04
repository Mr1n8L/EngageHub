package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class UpdateCustomerProjectionRoot<PARENT extends BaseSubProjectionNode<?, ?>, ROOT extends BaseSubProjectionNode<?, ?>> extends BaseSubProjectionNode<PARENT, ROOT> {
  public UpdateCustomerProjectionRoot() {
    super(null, null, java.util.Optional.of("Customer"));
  }

  public UpdateCustomerProjectionRoot<PARENT, ROOT> __typename() {
    getFields().put("__typename", null);
    return this;
  }

  public UpdateCustomerProjectionRoot<PARENT, ROOT> id() {
    getFields().put("id", null);
    return this;
  }

  public UpdateCustomerProjectionRoot<PARENT, ROOT> name() {
    getFields().put("name", null);
    return this;
  }

  public UpdateCustomerProjectionRoot<PARENT, ROOT> email() {
    getFields().put("email", null);
    return this;
  }

  public UpdateCustomerProjectionRoot<PARENT, ROOT> phoneNumber() {
    getFields().put("phoneNumber", null);
    return this;
  }
}
