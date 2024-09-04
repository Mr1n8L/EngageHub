package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class AddBusinessProjectionRoot<PARENT extends BaseSubProjectionNode<?, ?>, ROOT extends BaseSubProjectionNode<?, ?>> extends BaseSubProjectionNode<PARENT, ROOT> {
  public AddBusinessProjectionRoot() {
    super(null, null, java.util.Optional.of("Business"));
  }

  public AddBusinessProjectionRoot<PARENT, ROOT> __typename() {
    getFields().put("__typename", null);
    return this;
  }

  public AddBusinessProjectionRoot<PARENT, ROOT> id() {
    getFields().put("id", null);
    return this;
  }

  public AddBusinessProjectionRoot<PARENT, ROOT> name() {
    getFields().put("name", null);
    return this;
  }

  public AddBusinessProjectionRoot<PARENT, ROOT> address() {
    getFields().put("address", null);
    return this;
  }

  public AddBusinessProjectionRoot<PARENT, ROOT> type() {
    getFields().put("type", null);
    return this;
  }

  public AddBusinessProjectionRoot<PARENT, ROOT> contactInformation() {
    getFields().put("contactInformation", null);
    return this;
  }
}
